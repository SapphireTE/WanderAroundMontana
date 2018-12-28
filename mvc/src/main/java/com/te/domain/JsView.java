package com.te.domain;

public class JsView {
    public static class Anonymous{}
    public static class Other extends Anonymous{} //{} means this is a class
    public static class User extends Other{}
    public static class Admin extends User{}
}
