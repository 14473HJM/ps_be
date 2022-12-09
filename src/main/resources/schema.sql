CREATE TABLE people
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    role VARCHAR(50),
    name VARCHAR(100),
    last_name VARCHAR(50),
    person_identification_id BIGINT,
    address_id BIGINT,
    birthday DATE,
    status VARCHAR(50),
    university_identification_id BIGINT,
    career_average DECIMAL,
    career_registration_date DATE,
    image_profile VARCHAR(250),
    academic_status VARCHAR(50),
    university_profile VARCHAR(50),
    user_id BIGINT
);

CREATE TABLE contacts
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    person_id BIGINT,
    contact_type VARCHAR(255),
    contact_scope VARCHAR(100),
    value VARCHAR(255)
);

CREATE TABLE identifications
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    identification_type VARCHAR(50),
    identification VARCHAR(50)
);

CREATE TABLE addresses
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    street VARCHAR(250),
    street_number VARCHAR(10),
    zip_code VARCHAR(10),
    detail VARCHAR(250),
    city VARCHAR(100),
    province VARCHAR(100),
    country VARCHAR(100)
);

CREATE TABLE internet_platforms
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    base_url VARCHAR(250),
    icon VARCHAR(250),
    is_social_network BIT(1),
    is_git_platform BIT(1),
    name VARCHAR(100)
);

CREATE TABLE platform_networks
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    person_id BIGINT,
    internet_platform_id BIGINT,
    profile_name VARCHAR(250)
);

CREATE TABLE platforms
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    type VARCHAR(250),
    name VARCHAR(255)
);

CREATE TABLE code_frameworks
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    name VARCHAR(250),
    type VARCHAR(250),
    `description` VARCHAR(250),
    image_link VARCHAR(250),
    icon_link VARCHAR(250)
);

CREATE TABLE code_languages
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    type VARCHAR(250),
    name VARCHAR(250)
);

CREATE TABLE technologies
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    type VARCHAR(250),
    name VARCHAR(250)
);

CREATE TABLE user_interfaces
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    type VARCHAR(250),
    name VARCHAR(250)
);

CREATE TABLE users
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(250) NOT NULL,
    person_id BIGINT,
    enabled BIT(1),
    account_expired BIT(1),
    account_locked BIT(1),
    password_expiration_date DATE ,
    credential_expired BIT(1),
    unique KEY UNIQUE_USERNAME(user_name)
);

CREATE TABLE user_roles
(
    user_id BIGINT,
    role VARCHAR(50)
);

CREATE TABLE invitations
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    legajo VARCHAR(50) NOT NULL,
    hash VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    link VARCHAR(250) NOT NULL,
    invitation_status VARCHAR(50) NOT NULL,
    used_date DATETIME,
    due_date_time DATETIME,
    number_of_deliveries INTEGER,
    unique KEY UNIQUE_HASH(hash)
);

CREATE TABLE projects
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    cohort_id BIGINT,
    `name` VARCHAR(100),
    `description` VARCHAR(250),
    objective TEXT,
    project_limit TEXT,
    project_type VARCHAR(100),
    project_status VARCHAR(100),
    end_date DATE,
    project_theme VARCHAR(100),
    is_real_project BIT(1),
    image_link VARCHAR(250),
    issue_tracker_id BIGINT,
    tutor_id BIGINT,
    academic_condition VARCHAR(100),
    conversation_id BIGINT,
    project_presentation_id BIGINT
);

CREATE TABLE project_students
(
    student_id BIGINT NOT NULL,
    project_id  BIGINT NOT NULL
);

CREATE TABLE project_observers
(
    observer_id BIGINT NOT NULL,
    project_id  BIGINT NOT NULL
);

CREATE TABLE project_presentations
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    presentation_video_link VARCHAR(250),
    demo_video_link VARCHAR(250),
    final_document_id BIGINT,
    delivery_link VARCHAR(250)
);

CREATE TABLE attachments
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    project_id BIGINT,
    owner_id BIGINT,
    attachment_link VARCHAR(250)
);

CREATE TABLE issue_trackers
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    internet_platform_id BIGINT,
    owner_name VARCHAR(250),
    project_name VARCHAR(250)
);

CREATE TABLE issue_tracker_links
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    issue_tracker_id BIGINT,
    link VARCHAR(250)
);

CREATE TABLE code_repositories
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    project_id BIGINT,
    internet_platform_id BIGINT,
    owner_name VARCHAR(100),
    repository_link VARCHAR(250),
    production_branch_name VARCHAR(100)
);

CREATE TABLE issues
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    project_id BIGINT,
    due_date DATE,
    issue_status VARCHAR(50),
    summary VARCHAR(250),
    resume VARCHAR(250),
    informer_id BIGINT,
    responsible_id BIGINT,
    conversation_id BIGINT
);

CREATE TABLE system_components
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    name VARCHAR(100),
    `description` VARCHAR(250),
    project_id BIGINT,
    platform_d BIGINT,
    technology_id BIGINT,
    code_language_id BIGINT,
    code_framework_id BIGINT
);

CREATE TABLE valuations
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    project_id BIGINT,
    valuation_type VARCHAR(50),
    value DECIMAL,
    evaluator_id BIGINT,
    resume VARCHAR(250)
);

CREATE TABLE comments
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    conversation_id BIGINT,
    commentator_id BIGINT,
    comment TEXT
);

CREATE TABLE conversations
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    topic VARCHAR(100)
);

CREATE TABLE meet_attendances
(
    attendance_id BIGINT,
    meet_id BIGINT
);

CREATE TABLE meet_guests
(
    guest_id BIGINT,
    meet_id BIGINT
);

CREATE TABLE meetings
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    project_id BIGINT,
    topic VARCHAR(255),
    `description` VARCHAR(255),
    meeting_date_time DATETIME,
    requester_id BIGINT,
    meeting_link VARCHAR(255),
    was_made BIT(1),
    minutes_of_meeting_id BIGINT
);

CREATE TABLE minutes_of_meetings
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    minutes_of_meeting TEXT
);

CREATE TABLE project_scopes
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    project_id BIGINT,
    scope VARCHAR(250)
);

CREATE TABLE cohorts
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    object_type VARCHAR(50),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(50),
    last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_updated_user VARCHAR(50),
    deleted_date DATETIME,
    deleted_user VARCHAR(50),
    record_status VARCHAR(50),
    quarter INTEGER,
    year INTEGER,
    name VARCHAR(100),
    cohort_status VARCHAR(100)
);