package com.projet9.mediscreen.Domain;

public class PatientStatusDto {

    private boolean hasNoRisk;
    private boolean isBorderline;
    private boolean isInDanger;

    private boolean isSubjectToEarlyOnSetRisk;

    public PatientStatusDto(boolean hasNoRisk, boolean isBorderline, boolean isInDanger, boolean isSubjectToEarlyOnSetRisk) {
        this.hasNoRisk = hasNoRisk;
        this.isBorderline = isBorderline;
        this.isInDanger = isInDanger;
        this.isSubjectToEarlyOnSetRisk = isSubjectToEarlyOnSetRisk;
    }

    public PatientStatusDto() {
    }

    public boolean isHasNoRisk() {
        return hasNoRisk;
    }

    public void setHasNoRisk(boolean hasNoRisk) {
        this.hasNoRisk = hasNoRisk;
    }

    public boolean isBorderline() {
        return isBorderline;
    }

    public void setBorderline(boolean borderline) {
        isBorderline = borderline;
    }

    public boolean isInDanger() {
        return isInDanger;
    }

    public void setInDanger(boolean inDanger) {
        isInDanger = inDanger;
    }

    public boolean isSubjectToEarlyOnSetRisk() {
        return isSubjectToEarlyOnSetRisk;
    }

    public void setSubjectToEarlyOnSetRisk(boolean subjectToEarlyOnSetRisk) {
        isSubjectToEarlyOnSetRisk = subjectToEarlyOnSetRisk;
    }

    @Override
    public String toString() {
        String s = "Status : ";
        if (hasNoRisk) {
            return s + "has no risk";
        } else if (isBorderline) {
            return s + "is borderline";
        } else if (isInDanger) {
            return s + "is in danger";
        }
        return s + " is subject to early set on risk";
    }
}
