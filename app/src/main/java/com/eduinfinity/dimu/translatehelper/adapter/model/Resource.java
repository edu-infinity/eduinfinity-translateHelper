package com.eduinfinity.dimu.translatehelper.adapter.model;

import com.eduinfinity.dimu.translatehelper.utils.Config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dimu on 10/23/14.
 */
public class Resource implements Model {
    private Map<String, String> content = new HashMap<String, String>();

    public static final String CONTENT = "content";
    public static final String PROJECT = "project";
    public static final String TRANSLATE = "translate";
    public static final String SOURCE = "source";
    private int currentStatus = Model.INIT;
    private String projectSlug;

    public Resource(String projectSlug) {
        this.projectSlug = projectSlug;
    }

    @Override
    public int getStatus() {
        return currentStatus;
    }

    @Override
    public synchronized void setStatus(int t) {
        currentStatus = t;
    }


    @Override
    public String[] getKeys() {
        return KEYS;
    }

    public Map<String, String> getContent() {
        return content;
    }
//
//    public void setContent(Map<String, String> content) {
//        this.content = content;
//    }

    public void putValue(String key, String value) {
        content.put(key, value);
    }

    public String getValue(String key) {
        return content.get(key);
    }


    public String getProjectSlug() {
        return projectSlug;
    }

    public String getSourcePath() {
        return "/" + projectSlug + Config.SourceFolder;
    }

    public String getTransPath() {
        return "/" + projectSlug + Config.TransFolder;
    }


    public static  class Source {
        public Resource resource ;
        public Source(Resource data ) {
            this.resource = data;

        }
    }

    public static class Translate {
        public Resource resource ;
        public Translate(Resource data ) {
            this.resource = data;

        }
    }
}
