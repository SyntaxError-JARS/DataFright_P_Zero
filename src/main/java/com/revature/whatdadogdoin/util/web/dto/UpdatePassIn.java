package com.revature.whatdadogdoin.util.web.dto;

public class UpdatePassIn {

    private String tableSelection;
    private String newCellName;
    private String oldCellName;

    public String getTableSelection() {
        return tableSelection;
    }

    public void setTableSelection(String tableSelection) {
        this.tableSelection = tableSelection;
    }

    public String getNewCellName() {
        return newCellName;
    }

    public void setNewCellName(String newCellName) {
        this.newCellName = newCellName;
    }

    public String getOldCellName() {
        return oldCellName;
    }

    public void setOldCellName(String oldCellName) {
        this.oldCellName = oldCellName;
    }
}
