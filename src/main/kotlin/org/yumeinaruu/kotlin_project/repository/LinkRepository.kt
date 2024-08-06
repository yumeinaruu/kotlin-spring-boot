package org.yumeinaruu.kotlin_project.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.yumeinaruu.kotlin_project.model.Link

@Repository
interface LinkRepository : JpaRepository<Link, Long> {
}