package com.leandro.apiapplication.service.impl;

import com.leandro.apiapplication.model.dto.response.ApplicationResponse;
import com.leandro.apiapplication.model.dto.response.CreateApplicationRequest;
import com.leandro.apiapplication.model.entity.Application;
import com.leandro.apiapplication.repository.ApplicationRepository;
import com.leandro.apiapplication.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public List<ApplicationResponse> get() {
        return applicationRepository
                .findAll()
                .stream()
                .map(this::toObject)
                .toList();
    }

    @Override
    public void create(CreateApplicationRequest request) {
        applicationRepository.save(toObject(request));
    }

    private Application toObject(CreateApplicationRequest request) {
        var application = new Application();
        application.setId(UUID.randomUUID());
        application.setName(request.name());
        application.setDescription(request.description());
        return application;
    }

    private ApplicationResponse toObject(Application application) {

        return new ApplicationResponse(application.getId(), application.getName());
    }
}
