data class UserDto(
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val nickName: String? = null,
    val profileImageUrl: String? = null,
    val location: String? = null,
    val provider: String? = null,
    val job: String? = null,
    val bio: String? = null,
    val recipes: List<String> = emptyList(),
    val savedRecipes: List<String> = emptyList(),
    val followingList: List<String> = emptyList(),
    val followerList: List<String> = emptyList(),
    val recentRecipeHistory: List<String> = emptyList()
) {
    fun toModel() = UserModel(
        id = id,
        email = email,
        name = name,
        nickName = nickName,
        profileImageUrl = profileImageUrl,
        location = location,
        provider = provider,
        job = job,
        bio = bio,
        recipes = recipes,
        savedRecipes = savedRecipes,
        followingList = followingList,
        followerList = followerList,
        recentRecipeHistory = recentRecipeHistory
    )
}