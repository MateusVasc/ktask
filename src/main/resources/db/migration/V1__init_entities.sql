-- USERS
CREATE TABLE users (
    id UUID PRIMARY KEY,
    nickname VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

-- PROJECTS
CREATE TABLE projects (
    id UUID PRIMARY KEY,
    owner_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_project_owner FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE CASCADE
);

-- BOARDS
CREATE TABLE boards (
    id UUID PRIMARY KEY,
    project_id UUID NOT NULL,
    CONSTRAINT fk_board_project FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE
);

-- PROJECT PARTICIPANTS (Join table)
CREATE TABLE project_participants (
    project_id UUID NOT NULL,
    user_id UUID NOT NULL,
    PRIMARY KEY (project_id, user_id),
    CONSTRAINT fk_participant_project FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
    CONSTRAINT fk_participant_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
