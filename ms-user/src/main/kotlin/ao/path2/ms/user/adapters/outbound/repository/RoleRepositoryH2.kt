package ao.path2.ms.user.adapters.outbound.repository

import ao.path2.ms.user.core.domain.Role
import ao.path2.ms.user.core.exceptions.ResourceExistsException
import ao.path2.ms.user.core.exceptions.ResourceNotFoundException
import ao.path2.ms.user.core.repository.RoleRepository
import ao.path2.ms.user.utils.mapping.Mapper
import org.springframework.stereotype.Component

@Component
class RoleRepositoryH2(private val repo: RoleRepositorySpringData, private val mapper: Mapper) : RoleRepository {

  override fun findByName(name: String): Role? {

    val role = repo.findByName(name) ?: return null

    return mapper.map(role, Role()) as Role
  }

  override fun save(role: Role): Role {

    val role1 = repo.findByName(role.name)

    if (role1 != null)
      throw ResourceExistsException("Role ${role.name} is not found")

    repo.save(
      mapper.map(
        role,
        ao.path2.ms.user.adapters.outbound.repository.entity.Role()
      ) as ao.path2.ms.user.adapters.outbound.repository.entity.Role
    )

    return role
  }

}