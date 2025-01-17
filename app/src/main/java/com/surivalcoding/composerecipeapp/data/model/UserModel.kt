
data class UserModel(
    val id: String,
    val email: String,
    val name: String,
    val nickName: String? = null,
    val profileImageUrl: String? = null,
    val location: String? = null,
    val provider: String? = null,
    val job: String? = null,
    val bio: String? = null,
    val recipes: List<String> = emptyList(),  // Recipe IDs
    val savedRecipes: List<String> = emptyList(),  // Saved Recipe IDs
    val followingList: List<String> = emptyList(),  // User IDs
    val followerList: List<String> = emptyList(),  // User IDs
    val recentRecipeHistory: List<String> = emptyList()  // Recipe IDs
)