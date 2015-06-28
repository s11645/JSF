package unit;
import org.richfaces.component.SortOrder;

public class PatientSortUnit {
        private SortOrder addSort = SortOrder.unsorted;
        private SortOrder firstSort = SortOrder.unsorted;
        private SortOrder secondSort = SortOrder.unsorted;
        private SortOrder peselSort = SortOrder.unsorted;
        private SortOrder weightSort = SortOrder.unsorted;
        private SortOrder heightSort = SortOrder.unsorted;

    public SortOrder getAddSort() {
        return addSort;
    }

    public void setAddSort(SortOrder addSort) {
        this.addSort = addSort;
    }

    public SortOrder getFirstSort() {
        return firstSort;
    }

    public void setFirstSort(SortOrder firstSort) {
        this.firstSort = firstSort;
    }

    public SortOrder getSecondSort() {
        return secondSort;
    }

    public void setSecondSort(SortOrder secondSort) {
        this.secondSort = secondSort;
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
