package com.rsel.dto;

/**
 * Establish a parameter object for the database connection
 * Created on 2017/3/4.
 */
public class DataSource {

	/**
	     * Database url
	     */
    private String url;

    /**
         * database username
         */
    private String username;

    /**
         * Database password
         */
    private String password;
    /**
         * Database driver name
         */
    private String drivercClassName;

    /**
         * Database name
         */
    private String dbName;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDrivercClassName() {
        return drivercClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDrivercClassName(String drivercClassName) {
        this.drivercClassName = drivercClassName;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", drivercClassName='" + drivercClassName + '\'' +
                ", dbName='" + dbName + '\'' +
                '}';
    }
}
