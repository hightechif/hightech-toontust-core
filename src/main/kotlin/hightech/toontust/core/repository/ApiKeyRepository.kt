package hightech.toontust.core.repository

import hightech.toontust.core.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String>