package ar.edu.utn.frc.tup.ps.psappbe.services.config;

import ar.edu.utn.frc.tup.ps.psappbe.domain.config.CodeLanguage;
import ar.edu.utn.frc.tup.ps.psappbe.domain.config.Platform;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.CodeLanguageEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.PlatformEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.CodeLanguageRepository;
import ar.edu.utn.frc.tup.ps.psappbe.repository.PlatformRepository;
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
public class PlatformServiceImpl
        extends BaseModelServiceImpl<Platform, PlatformEntity>
        implements PlatformService {

    private final PlatformRepository platformRepository;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return platformRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
