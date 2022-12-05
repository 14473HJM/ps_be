package ar.edu.utn.frc.tup.ps.psappbe.controllers;

import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Invitation;
import ar.edu.utn.frc.tup.ps.psappbe.dtos.InvitationRequest;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.InvitationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.UnavailableException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ps/invitations")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class InvitationController {

    private final InvitationService invitationService;

    @PostMapping()
    public ResponseEntity<Invitation> createInvitation(@RequestBody InvitationRequest invitationRequest) {
        Invitation invitation = invitationService.createInvitation(invitationRequest.getLegajo(), invitationRequest.getEmail());
        return ResponseEntity.ok(invitation);
    }

    @GetMapping("/hash/{hash}")
    public ResponseEntity<Invitation> getInvitationWhitHash(@PathVariable String hash) {
        Invitation invitation = invitationService.getInvitation(hash);
        return ResponseEntity.ok(invitation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invitation> getInvitation(@PathVariable Long id) {
        Invitation invitation = invitationService.getById(id);
        return ResponseEntity.ok(invitation);
    }

    @PostMapping("/{id}/resend")
    public ResponseEntity<Invitation> resendInvitation(@PathVariable Long id) throws UnavailableException {
        Invitation invitation = invitationService.resendInvitation(id);
        return ResponseEntity.ok(invitation);
    }

    @GetMapping()
    public ResponseEntity<List<Invitation>> getAll(@RequestParam Optional<String> user) {
        List<Invitation> invitationList;
        if(user.isPresent()) {
            invitationList = invitationService.getInvitations(user.get());
        } else {
            invitationList = invitationService.getAll();
        }
        return ResponseEntity.ok(invitationList);
    }
}
