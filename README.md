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

Coloca la captura del grafo de ramas en la carpeta `img/` con el nombre `branch-graph.png`. La referencia ya está añadida aquí para que veas exactamente dónde colocarla:

![Grafo de ramas](./img/branch-graph.png)

(Si más adelante quieres añadir otras capturas, añádelas en `img/` y enlázalas de forma similar.)

## Créditos / IA

Si usaste IA en parte del proceso, cítala aquí. En este caso se usaron tus instrucciones (prompts) y la implementación fue generada/ajustada en el código del repositorio.

## Notas finales

- Si quieres que cambie el comportamiento (más separación, rebote, límite de shards, sonidos), indícalo y lo implemento.
- Confirma si quieres que haga el commit final en la rama `styles` y empuje (puedo preparar el commit, pero necesitarás ejecutar el push desde tu entorno con tus credenciales).

---

Si deseas cambios en el formato o contenido del README, lo actualizo rápidamente.

# GameToFork — Mejoras y entrega

Este README sustituye al original y documenta las mejoras implementadas para la entrega del ejercicio.

## Resumen del proyecto

GameToFork es un juego en JavaFX donde círculos caen desde la parte superior. El jugador hace click en los círculos para sumar puntos. Si un círculo llega a la línea inferior, el jugador pierde una vida; al perder todas las vidas aparece la pantalla de "Game Over".

En este fork se han añadido mejoras visuales y de jugabilidad para practicar gestión de ramas y despliegue de un fork.

## Funcionalidades principales añadidas

- Degradados en los círculos: los círculos usan degradados (radial o lineal) aleatorios para un aspecto más atractivo. Archivo: `src/main/java/com/ieselgrao/gametofork/util/GradientFactory.java`.
- Ruptura en shards (partículas): cuando un círculo es clicado o cuando supera la línea de pérdida, se rompe en trozos que caen y se acumulan en el fondo. Implementado en `ParticleFactory` y `ShardData`.
- Física simple para shards: gravedad, resistencia del aire y parada/acomodado en la línea inferior.
- Explosión escalada por radio: círculos mayores generan más trozos y con mayor separación.

Archivos añadidos/ modificados (resumen):

- `src/main/java/com/ieselgrao/gametofork/util/GradientFactory.java` (nuevo)
- `src/main/java/com/ieselgrao/gametofork/util/ParticleFactory.java` (nuevo)
- `src/main/java/com/ieselgrao/gametofork/util/ShardData.java` (nuevo)
- `src/main/java/com/ieselgrao/gametofork/controller/GameController.java` (modificado)

Si quieres, puedo adaptar el comportamiento (rebote, limpieza de shards antiguos, paletas de colores, sonido al romper) — dime cuál prefieres.

## Cómo compilar y ejecutar

Requisitos: JDK (compatible con la versión configurada en el `pom.xml`), Maven y JavaFX configurado si ejecutas con Maven.

Compilar:

```bash
cd "/ruta/al/repositorio"
sh ./mvnw -DskipTests compile
```

Ejecutar desde IDE: lanza la clase `com.ieselgrao.gametofork.MainApplication`.

Ejecutar con Maven (opcional):

```bash
sh ./mvnw javafx:run
```

## Flujo de trabajo (pasos que debes entregar)

Estos pasos siguen lo pedido en el enunciado. A continuación hay comandos de ejemplo; tú debes usarlos con tus URLs y ramas.

1. Crea un repositorio vacío en tu cuenta de GitHub (por ejemplo `gameFork-<tu_usuario>`).
2. Clona este repositorio original y configura el remoto `origin` a tu repositorio:

```bash
git clone https://github.com/LacruzJSDev/gameFork.git
cd gameFork
git remote rename origin upstream
git remote add origin https://github.com/<tu_usuario>/gameFork-<tu_usuario>.git
git push -u origin main
```

3. Crea una nueva rama para desarrollar (puedes usar GitKraken):

```bash
git checkout -b feature/<tu-mejora>
```

4. Haz cambios, commit y push a tu rama:

```bash
git add .
git commit -m "feat: añadir degradados y shards"
git push -u origin feature/<tu-mejora>
```

5. Fusiona (merge) la rama `feature/<tu-mejora>` en `main` (haz PR y merge o usa GitKraken).

En la plataforma de entrega (Aules) solo debes pegar el enlace en texto plano a tu repositorio y marcarlo como entregado.

## Capturas y evidencias

Coloca las imágenes que muestren el proceso (capturas de GitKraken mostrando la rama, PR, y del juego) en la carpeta `img/`. Inserta las imágenes aquí con Markdown:

```markdown
![Demo juego](./img/demo-capture.png)
![GitKraken rama](./img/gitkraken-branch.png)
```

## Créditos y uso de IA

Si has usado IA para ayudarte en alguna parte del desarrollo, cítala en esta sección. Un ejemplo de cita:

> Partes del código y sugerencias visuales generadas con ayuda de un modelo de lenguaje (2025). Código adaptado y revisado por el autor.

## Notas finales

- Si el rendimiento sufre por demasiados shards, se puede añadir un límite y una limpieza por tiempo o cantidad (lo implemento si quieres).
- Dime si quieres que añada:
  - rebote/fricción para shards,
  - paletas temáticas (pastel/frío/calor),
  - sonidos al romper,
  - o limitación/garbage-collection de shards.

---

Si quieres que ajuste el README (más secciones, badges, tabla de commits relevantes o incluir capturas concretas), lo hago ahora.

# A Game to be Improved

**[ES] - English below**

Este repositorio es un proyecto de JavaFX para practicar la creación y modificación de un repositorio propio a partir de una base.

## Objetivos

El objetivo principal es hacer un _fork_ (bifuración) del proyecto, para mejorar la lógica del juego o añadir funcionalidades y crear un repositorio donde se vea esto.
Además, deberás hacerlo en una nueva **rama (branch)** de desarrollo y después fusionar los cambios con la principal. También deberás crear un archivo README.md donde expliques tus mejoras.

Como novedad, vamos a usar el cliente Git [GitKraken](https://www.gitkraken.com/). Un cliente Git es un software que nos proporciona una interfaz para gestionar y visualizar todos los cambios de un repositorio. En principio, no necesitaremos usar comandos y todo será -en principio- más intuitivo. Aun así, seguramente tengas que buscar algo de información para algún paso.

He elegido GitKraken por estar disponible en Windows, Linux y MacOS. Ignorad sus propuestas de plan de pago. Es posible que os llegue algún correo comercial, ¡mil disculpas! Desuscribiros de sus _newsletter_.

Los pasos se resumen en los siguientes. ¡No te olvides de sacar capturas!

1. Crea un repositorio vacío en tu cuenta con la interfaz web de GitHub.
2. Clona este repositorio en tu PC. Modifica el origen remoto para añadir tu nuevo repositorio.
3. **Crea una nueva rama (branch)** con la ayuda de la UI de GitKraken.
4. Modifica el proyecto para añadir funcionalidades. Puede servir cualquier aspecto de la jugabilidad (sistema de puntuación, calibración de la velocidad, ajustes de la interfaz, incorporación de imágenes o música).
5. Realiza al menos un commit y un push a esta branch.
6. Fusiona los cambios en tu rama secundaria con tu rama principal.
7. Borra este archivo `README.md` y crea uno nuevo desde cero en el que expliques qué funcionalidades has añadido. Además, deberás explicar en este archivo cómo ha sido el proceso creando tu _fork_ del proyecto, adjuntando las capturas correspondientes. ¡Se valorará el formato correcto de este archivo!
8. En el aules solamente dejarás el link (en texto plano) a tu repositorio. Márcalo como entregado una vez hayas acabado. Se valorará el último commit antes de la fecha de entrega.

[Aquí](https://github.com/alvaro-ruizg/LearnGit/blob/main/MarkDownFormatExample.md) tienes algo de ayuda para crear tu archivo `README.md`. Deja tus imágenes en un directorio llamado img y muestralas con:
`![Alt Text](./img/demoimage.png)`

Para ver correctamente el contenido de un archivo `.md` antes de subirlo puedes usar el propio editor de IntelliJ, extensiones de VSCode o extensiones del navegador como [Markdown Reader](https://chromewebstore.google.com/detail/markdown-reader/medapdbncneneejhbgcjceippjlfkmkg?pli=1).

## Cómo ejecutar el proyecto

Este proyecto está configurado con **Maven**. Usa JavaFX para la interfaz de usuario. Se recomienda el IDE IntelliJ para ejecutarlo correctamente.

Te recomiendo ver (y respetar) la estructura de directorios. Este proyecto sigue la arquitectura Model-Controller-View (MCV). Esto quiere decir que las clases se dividen en:

- Model: Clases como GameModel, que se encargan de la lógica interna del programa.
- Controller: Clases como GameOverController, se encargan de conectar la interfaz gráfica con la lógica interna del juego.
- View: Archivos como `game-view.fxml`, que muestran el contenido de la interfaz.

## Uso de la IA generativa

Si haces uso de IA para el proceso de mejora de algun aspecto de la lógica del juego, **cítala correctamente**. [Cómo citar a la IA - UOC](https://openaccess.uoc.edu/server/api/core/bitstreams/2ef41918-449d-4033-a6c7-1f04dad489dd/content)

En mi caso, sería algo como:

- Juego generado con Google Gemini, modelo de lenguaje grande (2025). Prompt usado:

```
Creame un juego en JavaFX. No necesito ninguna funcionalidad de base de datos.

Simplemente habrá circulos de tamaño alteatorio (entre un min y un max) cayendo desde arriba abajo de la pantalla.

Hacer click en los circulos da puntos, si rebasan una linea (situada en el pie de la pantalla), perderan una vida. Al perder 3 vidas se acaba el juego.

Hazme también en fxml:

- Una pantalla de juego.
- Una pantalla de inicio
- Una pantalla de game over.


Créame tambien las clases necesarias para la logica del juego, de acuerdo a la arquitectura Controlador-Modelo-Vista
```

---

# A Game to be Improved

**[EN] - Spanish above**

This repository is a JavaFX project intended for practicing the creation and modification of your own repository based on a starter project.

## Objectives

The main objective is to **fork** the project to improve the game's logic or add new features, creating a repository where these changes are visible.

Additionally, you must perform this work in a new development **branch** and subsequently **merge** the changes with the main branch. You must also create a `README.md` file explaining your improvements.

As a novelty, we will be using the Git client **[GitKraken](https://www.gitkraken.com/)**. A Git client is software that provides an interface to manage and visualize all changes within a repository. In theory, we won't need to use commands, and everything will be — in principle — more intuitive. Even so, you will likely need to search for information for some steps.

I have chosen GitKraken because it is available on Windows, Linux, and macOS. Please ignore their paid plan proposals. You might receive some promotional emails; my apologies\! Unsubscribe from their newsletters.

The steps are summarized below. **Don't forget to take screenshots\!**

1.  Create an empty repository on your account using the GitHub web interface.
2.  Clone this repository to your PC. Modify the remote origin to point to your new repository.
3.  **Create a new branch** using the GitKraken UI.
4.  Modify the project to add new functionalities. This can be any aspect of the gameplay (scoring system, speed calibration, interface adjustments, incorporating images or music).
5.  Perform at least one **commit** and one **push** to this branch.
6.  **Merge** the changes from your secondary branch into your main branch.
7.  Delete this `README.md` file and create a new one from scratch in which you explain what functionalities you have added. Furthermore, you must explain in this file how the process of creating your **fork** of the project was, attaching the corresponding screenshots. **Proper formatting of this file will be assessed\!**
8.  In the Aules platform, you will only submit the link (in plain text) to your repository. Mark it as delivered once you have finished. The last commit before the submission deadline will be evaluated.

You can find some help for creating your `README.md` file [here](https://github.com/alvaro-ruizg/LearnGit/blob/main/MarkDownFormatExample.md). Place your images in a directory named `img` and display them using:
`![Alt Text](./img/demoimage.png)`

To properly view the content of a `.md` file before uploading, you can use the built-in IntelliJ editor, VSCode extensions, or browser extensions like [Markdown Reader](https://chromewebstore.google.com/detail/markdown-reader/medapdbncneneejhbgcjceippjlfkmkg?pli=1).

---

## How to Run the Project

This project is configured with **Maven**. It uses JavaFX for the user interface. The IntelliJ IDE is recommended for correct execution.

I recommend reviewing (and respecting) the directory structure. This project follows the **Model-Controller-View (MCV)** architecture. This means the classes are divided into:

- **Model:** Classes, like `GameModel`, that handle the internal logic of the program.
- **Controller:** Classes, like `GameOverController`, that connect the graphical interface with the internal game logic.
- **View:** Files, like `game-view.fxml`, that display the interface content.

---

## Use of Generative AI

If you use AI for the process of improving any aspect of the game's logic, **cite it correctly**. [How to cite AI - UOC](https://openaccess.uoc.edu/server/api/core/bitstreams/2ef41918-449d-4033-a6c7-1f04dad489dd/content)

In my case, the citation would be something like:

- Game generated with Google Gemini, large language model (2025). Prompt used:

  ```
  Creame un juego en JavaFX. No necesito ninguna funcionalidad de base de datos.

  Simplemente habrá circulos de tamaño alteatorio (entre un min y un max) cayendo desde arriba abajo de la pantalla.

  Hacer click en los circulos da puntos, si rebasan una linea (situada en el pie de la pantalla), perderan una vida. Al perder 3 vidas se acaba el juego.

  Hazme también en fxml:

  - Una pantalla de juego.
  - Una pantalla de inicio
  - Una pantalla de game over.


  Créame tambien las clases necesarias para la logica del juego, de acuerdo a la arquitectura Controlador-Modelo-Vista
  ```
