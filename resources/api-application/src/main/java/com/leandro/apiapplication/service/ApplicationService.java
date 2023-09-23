package com.leandro.apiapplication.service;

import com.leandro.apiapplication.model.dto.response.ApplicationResponse;
import com.leandro.apiapplication.model.dto.response.CreateApplicationRequest;

import java.util.List;

public interface ApplicationService {

    List<ApplicationResponse> get ();
    void create(CreateApplicationRequest request);
}
