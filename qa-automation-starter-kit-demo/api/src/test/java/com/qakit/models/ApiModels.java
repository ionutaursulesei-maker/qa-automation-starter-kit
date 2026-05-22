package com.qakit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO models — example data classes for API serialisation / deserialisation.
 *
 * @JsonIgnoreProperties(ignoreUnknown = true) — ignores fields returned by the response
 * that are not explicitly mapped here. Useful when the API returns more than you need.
 *
 * NOTE: These POJOs alone are not enough to run API tests. The full kit includes:
 *  - BaseApiTest with RestAssured configuration + Allure logging filter
 *  - PostsApiTest with 9 complete CRUD scenarios (GET/POST/PUT/PATCH/DELETE + performance)
 *  - Bearer token authentication helpers
 *
 * → Full kit: https://aionut.gumroad.com/l/qa_automation_starter_kit
 */
public class ApiModels {

    // -------------------------------------------------------------------------
    // Post
    // -------------------------------------------------------------------------

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Post {

        @JsonProperty("id")
        private Integer id;

        @JsonProperty("userId")
        private Integer userId;

        @JsonProperty("title")
        private String title;

        @JsonProperty("body")
        private String body;

        public Post() {}

        public Post(Integer userId, String title, String body) {
            this.userId = userId;
            this.title  = title;
            this.body   = body;
        }

        public Integer getId()              { return id; }
        public void setId(Integer id)       { this.id = id; }

        public Integer getUserId()          { return userId; }
        public void setUserId(Integer uid)  { this.userId = uid; }

        public String getTitle()            { return title; }
        public void setTitle(String t)      { this.title = t; }

        public String getBody()             { return body; }
        public void setBody(String b)       { this.body = b; }

        @Override
        public String toString() {
            return "Post{id=" + id + ", userId=" + userId + ", title='" + title + "'}";
        }
    }

    // -------------------------------------------------------------------------
    // User
    // -------------------------------------------------------------------------

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {

        @JsonProperty("id")
        private Integer id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("username")
        private String username;

        @JsonProperty("email")
        private String email;

        public User() {}

        public User(String name, String username, String email) {
            this.name     = name;
            this.username = username;
            this.email    = email;
        }

        public Integer getId()              { return id; }
        public void setId(Integer id)       { this.id = id; }

        public String getName()             { return name; }
        public void setName(String n)       { this.name = n; }

        public String getUsername()         { return username; }
        public void setUsername(String u)   { this.username = u; }

        public String getEmail()            { return email; }
        public void setEmail(String e)      { this.email = e; }

        @Override
        public String toString() {
            return "User{id=" + id + ", username='" + username + "', email='" + email + "'}";
        }
    }

    // -------------------------------------------------------------------------
    // ErrorResponse — for error responses (4xx, 5xx)
    // -------------------------------------------------------------------------

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ErrorResponse {

        @JsonProperty("message")
        private String message;

        @JsonProperty("status")
        private Integer status;

        @JsonProperty("error")
        private String error;

        public String getMessage() { return message; }
        public Integer getStatus() { return status; }
        public String getError()   { return error; }
    }
}
