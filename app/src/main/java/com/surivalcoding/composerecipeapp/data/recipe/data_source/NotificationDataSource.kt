import com.surivalcoding.composerecipeapp.data.recipe.ingrident.IngredientModel


interface NotificationDataSource{
    suspend fun getNotifications(): List<NotificationModel>
}