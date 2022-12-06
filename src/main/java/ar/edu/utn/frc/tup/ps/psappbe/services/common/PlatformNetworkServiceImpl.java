package ar.edu.utn.frc.tup.ps.psappbe.services.common;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.PlatformNetwork;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.PlatformNetworkEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ContactRepository;
import ar.edu.utn.frc.tup.ps.psappbe.repository.PlatformNetworkRepository;
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
public class PlatformNetworkServiceImpl extends BaseModelServiceImpl<PlatformNetwork, PlatformNetworkEntity> implements PlatformNetworkService {

    private final PlatformNetworkRepository platformNetworkRepository;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return platformNetworkRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

}
