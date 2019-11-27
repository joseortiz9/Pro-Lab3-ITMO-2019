package ru.students.lab;

public class Feeling {
    private TypesFeelings typeFeeling;
    private boolean isFelt;

    public Feeling(TypesFeelings typeFeeling, boolean isFelt) {
        this.typeFeeling = typeFeeling;
        this.isFelt = isFelt;
    }

    public TypesFeelings getTypeFeeling() {
        return typeFeeling;
    }

    public void changeIsFelt() {
        this.isFelt = !this.isFelt;
    }

    public boolean isFelt() {
        return isFelt;
    }

    @Override
    public int hashCode() {
        int happening = (this.isFelt()) ? 1: 0;
        return this.getTypeFeeling().toString().hashCode() + happening;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Feeling))
            return false;
        if (obj == this)
            return true;
        Feeling objFeeling = (Feeling) obj;
        return this.isFelt() == objFeeling.isFelt() &&
                this.getTypeFeeling().equals(objFeeling.getTypeFeeling());
    }

    @Override
    public String toString() {
        return "[" + this.getTypeFeeling().toString() + "=" + this.isFelt() + "]";
    }
}
