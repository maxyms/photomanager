package com.skotarenko.photomanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skotarenko.photomanager.business.File;

public class DuplicatesFinder {
    private static final Logger logger = LoggerFactory.getLogger(DuplicatesFinder.class);

    public Duplicates findDuplicates(Collection<File> files) {
        Duplicates res = new Duplicates();
        //        logger.debug("Find duplicates...");
        Map<IKey, Collection<File>> duplicates = compareFiles(files);
        Function<Map.Entry<IKey, Collection<File>>, DuplicateEntry> mapper = e -> new DuplicateEntry(((NameSizeKey) e.getKey()).getName(), e.getValue());
        Collection<DuplicateEntry> duplicateEntries = duplicates.entrySet().stream().map(mapper).collect(Collectors.toList());
        logger.debug("Total duplicates: " + duplicates.size());
        printDuplicates(duplicates);
        Long totalSize = duplicateEntries.stream().map(d -> d.getFiles()).flatMap(l -> l.stream()).mapToLong(f -> f.getSize()).sum();
        //        files.stream().forEach(f -> logger.debug("\t" + f.getName() + " " + Arrays.toString(f.getColorSchema())));
        ///
        //        File orig = new File();
        //        orig.setColorSchema(new int[] { -5199195, -5274514, -8951457, -14014425 });
        //        compareFiles2(orig, files);
        //        logger.debug("Total files: " + files.size());
        //        logger.debug("Total duplicates: " + duplicates.size());
        //        logger.debug("End duplicates...");
        res.setEntries(duplicateEntries);
        res.setTotalSize(totalSize);
        return res;
    }

    private Map<IKey, Collection<File>> compareFiles(Collection<File> files) {
        final Map<IKey, Collection<File>> result = new HashMap<IKey, Collection<File>>();
        files.stream().forEach(f -> {
            IKey key = new NameSizeKey(f);
            if (result.get(key) == null) {
                result.put(key, new ArrayList<File>());
            }
            result.get(key).add(f);
        });
        return result.entrySet().stream().filter(new Predicate<Entry<IKey, Collection<File>>>() {
            @Override
            public boolean test(Entry<IKey, Collection<File>> t) {
                return t.getValue().size() > 1;
            }
        }).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }

    private void compareFiles2(File orig, Collection<File> files) {
        final Map<IKey, Collection<File>> result = new HashMap<IKey, Collection<File>>();
        files.stream().forEach(f -> calculateDistance(orig.getColorSchema(), f.getColorSchema()));
    }

    private long calculateDistance(int[] r1, int[] r2) {
        long res = 0;
        for (int i = 0; i < r1.length; i++) {
            logger.debug("r1=" + r1[i] + ", r2=" + r2[i] + ": " + (r1[i] - r2[i]) * (r1[i] - r2[i]));
            res += (r1[i] - r2[i]) * (r1[i] - r2[i]);
        }
        logger.debug("" + res);
        res = Math.round(Math.sqrt(res));
        logger.debug("Distance: " + res);
        return res;
    }

    private void printDuplicates(Map<IKey, Collection<File>> duplicates) {
        duplicates.entrySet().stream().forEach(e -> {
            logger.debug("Duplicate entry: " + e.getKey());
            e.getValue().stream().forEach(f -> logger.debug("\t" + f.getPath()));
        });
    }
}
