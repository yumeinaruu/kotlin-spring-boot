package org.yumeinaruu.kotlin_project.model

import jakarta.persistence.*
import org.springframework.stereotype.Component
import java.sql.Timestamp

@Entity(name="users")
@Component
class User {
    @Id
    @SequenceGenerator(name = "linksIdSeqGen", sequenceName = "links_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "linksIdSeqGen")
    private var id: Long? = null

    @Column(name = "username")
    private var username: String? = null

    @Column(name = "description")
    private var description: String? = null

    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private var created: Timestamp? = null

    @Column(name = "changed")
    @Temporal(TemporalType.TIMESTAMP)
    private var changed: Timestamp? = null

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private var links: MutableSet<Link> = mutableSetOf()

    fun getId(): Long? = id

    fun getUsername(): String? = username

    fun getDescription(): String? = description

    fun getCreated(): Timestamp? = created

    fun getChanged(): Timestamp? = changed

    fun getLinks(): MutableSet<Link> = links

    fun setUsername(newUsername: String?) {
        this.username = newUsername
    }

    fun setDescription(newDescription: String?) {
        this.description = newDescription
    }

    fun setCreated(newCreated: Timestamp?) {
        this.created = newCreated
    }

    fun setChanged(newChanged: Timestamp?) {
        this.changed = newChanged
    }

    override fun toString(): String {
        return "User(id=$id, username=$username, description=$description, created=$created, changed=$changed, links=$links)"
    }
}