//[AppNotas](../../../index.md)/[com.example.appnotas](../index.md)/[ImagePagerAdapter](index.md)/[onBindViewHolder](on-bind-view-holder.md)

# onBindViewHolder

[androidJvm]\
open override fun [onBindViewHolder](on-bind-view-holder.md)(holder: [ImagePagerAdapter.ViewHolder](-view-holder/index.md), position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html))

Vincula los datos de las imágenes al ViewHolder correspondiente. Este método utiliza Glide para cargar la imagen desde un URI y mostrarla en el `imageView`.

#### Parameters

androidJvm

| | |
|---|---|
| holder | Instancia del ViewHolder que gestionará el elemento actual. |
| position | Posición del elemento en la lista de imágenes. |
