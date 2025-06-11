package com.matt.ktask.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import java.time.LocalDateTime
import java.util.UUID

@Table(name = "users")
@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(nullable = false, unique = true)
    var nickname: String,

    @Email
    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    var password: String
) {
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @OneToMany(mappedBy = "owner", cascade = [CascadeType.ALL], orphanRemoval = true)
    var projectsOwned: MutableList<Project> = mutableListOf()

    @ManyToMany(mappedBy = "participants")
    var projectsSharedWith: MutableList<Project> = mutableListOf()
}