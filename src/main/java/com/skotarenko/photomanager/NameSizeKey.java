package com.skotarenko.photomanager;

public class NameSizeKey implements IKey {
    private String name;
    private Long size;

    public NameSizeKey(File f) {
        this.name = f.getName();
        this.size = f.getSize();
    }

    @Override
    public String toString() {
        return "NameSizeKey [name=" + name + ", size=" + size + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NameSizeKey other = (NameSizeKey) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (size == null) {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
            return false;
        return true;
    }
}
