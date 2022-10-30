package ar.edu.utn.frc.tup.ps.psappbe.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InternetPlatform {

    LINKEDIN("", "", true, false),
    FACEBOOK("", "", true, false),
    INSTAGRAM("", "", true, false),
    TWEETER("", "", true, false),
    YOUTUBE("", "", true, false),
    GITHUB("", "", false, true),
    GITLAB("", "", false, true),
    BITBUCKET("", "", false, true),
    JIRA("", "", false, false);

    private String baseUrl;
    private String icon;
    private Boolean isSocialNetwork;
    private Boolean isGitPlatform;
}
