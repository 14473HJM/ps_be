package ar.edu.utn.frc.tup.ps.psappbe.services.config;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import ar.edu.utn.frc.tup.ps.psappbe.domain.config.CodeLanguage;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.CodeLanguageEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.InternetPlatformEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.CodeLanguageRepository;
import ar.edu.utn.frc.tup.ps.psappbe.repository.InternetPlatformRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InternetPlatformServiceImpl
        extends BaseModelServiceImpl<InternetPlatform, InternetPlatformEntity>
        implements InternetPlatformService {

    private final InternetPlatformRepository internetPlatformRepository;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return internetPlatformRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
