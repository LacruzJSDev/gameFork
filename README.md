# GameToFork — README final (rama: styles)

## Resumen del proyecto

Juego simple en JavaFX: círculos caen desde la parte superior; hacer click en un círculo otorga puntos; si un círculo llega a la línea inferior se pierde una vida. Al perder todas las vidas se muestra la pantalla "Game Over".

En este fork se implementaron mejoras visuales y de interacción para la práctica.

## Funcionalidades añadidas

- Degradados en los círculos (radial/linear aleatorio) — `GradientFactory`.
- Ruptura en shards (partículas) cuando se hace click o cuando un círculo sobrepasa la línea — `ParticleFactory` + `ShardData`.
- Física básica para shards: gravedad, resistencia del aire y acumulación en la línea inferior.
- Explosión escalada por radio: círculos más grandes generan más shards y con mayor separación.

Archivos relevantes añadidos/modificados:

- `src/main/java/com/ieselgrao/gametofork/util/GradientFactory.java` (nuevo)
- `src/main/java/com/ieselgrao/gametofork/util/ParticleFactory.java` (nuevo)
- `src/main/java/com/ieselgrao/gametofork/util/ShardData.java` (nuevo)
- `src/main/java/com/ieselgrao/gametofork/controller/GameController.java` (modificado)

## Prompts que se utilizaron (textos exactos que diste, excluyendo el prompt del README)

A continuación incluyo los prompts que me diste en este repositorio y que guiaron los cambios implementados:

1. "Puedes encontrar en el proyecto donde se configuran los colores de los circulos? (See <attachments> above for file contents. You may not need to search or read the file again.)"

2. "puedes cambiarme esto para que los colores sean degradados para hacer algo más chulo? si necesitas crear otro modulo para separarlo de la lógica principal, hazlo (See <attachments> above for file contents. You may not need to search or read the file again.)"

3. "puedes hacer que cuando el circulo llegue al final se rompa en trocitos y se acumulen el fondo? Crea los archivos que necesites (See <attachments> above for file contents. You may not need to search or read the file again.)"

4. "puedes hacer que pase cuando haces click en un circulos? que se rompan caigan, estria bien si se separen un poco más (See <attachments> above for file contents. You may not need to search or read the file again.)"

Estos prompts orientaron la creación de `GradientFactory`, `ParticleFactory`, `ShardData` y las modificaciones en `GameController`.

## Cómo compilar y ejecutar

Requisitos: JDK, Maven. El proyecto usa el wrapper Maven incluido.

Compilar:

```bash
cd "/ruta/al/repositorio"
sh ./mvnw -DskipTests compile
```

Ejecutar desde IDE: ejecuta la clase `com.ieselgrao.gametofork.MainApplication`.

Ejecutar con Maven (opcional):

```bash
sh ./mvnw javafx:run
```

## Flujo Git que usé / sugerido (con la rama `styles`)

Ejemplo mínimo para dejar evidencia en tu repositorio remoto (reemplaza las URLs por las tuyas):

```bash
# clona el repo base
git clone https://github.com/LacruzJSDev/gameFork.git
cd gameFork

# renombra el origin del upstream para mantenerlo
git remote rename origin upstream

# añade tu repo remoto y púsh
git remote add origin https://github.com/<tu_usuario>/gameFork.git
git push -u origin main

# crea y usa la rama 'styles' (ya la creaste según indicas)
git checkout -b styles

# haz cambios (ya realizados aquí), commit y push a 'styles'
git add .
git commit -m "feat: añadir degradados y shards"
git push -u origin styles

# una vez revisado, fusiona 'styles' -> 'main' (desde UI o PR)
```

## Imágenes

Gráfico de las ramas.

![Grafo de ramas](./img/branch-graph.png)

## Créditos / IA

Si usaste IA en parte del proceso, cítala aquí. En este caso se usaron tus instrucciones (prompts) y la implementación fue generada/ajustada en el código del repositorio.
