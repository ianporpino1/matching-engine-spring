package com.matchingengine.controller.dto;

public record UserRequest(String username, String password, Boolean isAdmin) {}
