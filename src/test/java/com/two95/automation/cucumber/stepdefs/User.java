package com.two95.automation.cucumber.stepdefs;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by vshula00c on 3/21/17.
 */
public class User {
   private String name;
   private String pass;

   public String getName() {
        return name;
    }

   public void setName(String name) {
        this.name = name;
    }

   public String getPass() {
        return pass;
    }

   public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
