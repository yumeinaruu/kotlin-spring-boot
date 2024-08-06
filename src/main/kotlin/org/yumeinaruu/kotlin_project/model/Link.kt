package org.yumeinaruu.kotlin_project.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.stereotype.Component

@Entity(name = "links")
@Component
class Link {
    @Id
    @SequenceGenerator(name = "linksIdSeqGen", sequenceName = "links_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "linksIdSeqGen")
    private var id: Long? = null

    @Column(name = "service")
    private var service: String? = null

    @Column(name = "link")
    private var link: String? = null

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne
    private var userId: User? = null

    fun getId(): Long? = id

    fun getService(): String? = service

    fun getLink(): String? = link

    fun getUserId(): String? = userId?.toString()

    override fun toString(): String {
        return "Link(id=$id, service=$service, link=$link, userId=$userId)"
    }
}