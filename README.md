# 🎬 Android Movies RecyclerView Demo

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-purple.svg)](https://kotlinlang.org)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

Un proyecto Android para practicar componentes esenciales con una lista de películas 🍿

## 🧩 Componentes principales

### 🎞️ Movie (Data Class)
```kotlin
data class Movie(
    val title: String,
    val year: Int,
    val director: String.
    val photo: String
)
```
- Estructura inmutable que representa una película

- Contiene propiedades básicas: título, año, director y URL del póster

### 📦 MovieProvider
```kotlin
class MovieProvider {
    companion object {
        val movieList = listOf<Movie>(
            Movie(
                "El Padrino",
                 972,
                "Francis Ford Coppola",
                "https://image.tmdb.org/t/p/w500/r4gnMXoY1efvaolNDjn3nj4046S.jpg"
            ),
      // ... más peliculas
```
- Clase utilitaria que provee datos de muestra
- Usa `companion object` para acceder directamente a `movieList`
- Simula una fuente de datos (base de datos/API)
- Retorna `List<Movie>` inmutable

### 🧩 MovieAdapter
```kotlin
class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = movieList.size
}
```

- Inyección de dependencia: Recibe `movieList` por constructor
- Inflado de vistas: Usa ``LayoutInflater`` para crear ViewHolders
- Método ``render()``: Delegado al ViewHolder para actualizar UI
- Conteo dinámico: ``getItemCount()`` usa el tamaño de la lista real

### 🖼 MovieViewHolder
```kotlin
class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // 1. Inicialización del ViewBinding
    private val binding = ItemMovieBinding.bind(view)

    // 2. Método para actualizar la UI
    fun render(movieModel: Movie) {
        with(binding) {
            // Asignación de datos a las vistas
            tvMovieName.text = movieModel.movieName       // TextView para el título
            tvMovieYear.text = movieModel.year.toString() // TextView para el año
            tvMovieDirector.text = movieModel.director    // TextView para el director
            
            // Carga de imagen con Glide
            Glide.with(ivMovie.context)
                .load(movieModel.photo)                   // URL del póster
                .into(ivMovie)                           // ImageView destino
        }
    }
}
```

1. **ViewBinding**:
    - Usa ``ItemMovieBinding.bind(view)`` para mapear las vistas XML
    - Elimina necesidad de ``findViewById``
    - Proporciona acceso seguro a tipos (tvMovieName, ivMovie, etc.)

2. **Método render()**:
   - Recibe objeto ``Movie`` como parámetro
   - Asigna datos a vistas mediante binding
   - Usa ``with(binding)`` para código más limpio

3. **Glide**:
   - Maneja carga asíncrona de imágenes
   - Administra caché y redimensionamiento automático
   - Previene memory leaks usando el contexto del ImageView

## 💡 Conceptos clave implementados
- ``RecyclerView`` con adapter personalizado
- Patrón ``ViewHolder`` para rendimiento
- ``ViewBinding`` para seguridad de tipos
- Estructura modular por componentes
- Datos simulados con clase utilitaria
