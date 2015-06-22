package entities;
import org.richfaces.component.SortOrder;

public class Sort {
        private SortOrder joinDateSort = SortOrder.unsorted;
        private SortOrder nameSort = SortOrder.unsorted;
        private SortOrder surnameSort = SortOrder.unsorted;
        private SortOrder peselSort = SortOrder.unsorted;
        private SortOrder weightSort = SortOrder.unsorted;
        private SortOrder heightSort = SortOrder.unsorted;

    public SortOrder getJoinDateSort() {
        return joinDateSort;
    }

    public void setJoinDateSort(SortOrder joinDateSort) {
        this.joinDateSort = joinDateSort;
    }

    public SortOrder getNameSort() {
        return nameSort;
    }

    public void setNameSort(SortOrder nameSort) {
        this.nameSort = nameSort;
    }

    public SortOrder getSurnameSort() {
        return surnameSort;
    }

    public void setSurnameSort(SortOrder surnameSort) {
        this.surnameSort = surnameSort;
    }

    public SortOrder getPeselSort() {
        return peselSort;
    }

    public void setPeselSort(SortOrder peselSort) {
        this.peselSort = peselSort;
    }

    public SortOrder getWeightSort() {
        return weightSort;
    }

    public void setWeightSort(SortOrder weightSort) {
        this.weightSort = weightSort;
    }

    public SortOrder getHeightSort() {
        return heightSort;
    }

    public void setHeightSort(SortOrder heightSort) {
        this.heightSort = heightSort;
    }
        
    
}
