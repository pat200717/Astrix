package com.astrix.Apps;

public abstract class Apps {
    
    private boolean installed;
    
    public Apps(boolean installed) {
        this.installed = installed;
    }
    
    public boolean isInstalled() {
        return installed;
    }
    
    public void install() {
        installed = true;
    }

    public abstract String getName();
    
    public abstract String creatorName();
    
    public abstract double sizeFile();
    
    public abstract String version();
    
    public abstract String description();
    
    public abstract String getCode();
    

    public abstract void run();

}