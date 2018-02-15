# Setup Instructions 

### Project Configuration

Since the project uses Gradle, all you have to do is import the project
from existing sources (if downloaded beforehand) or import from VCS in
GitHub and it should work fine. 

Before you contribute to this repository, please read the Checkstyle
section below. It enforces a uniform code style across the repository.

### Checkstyle
All code in this repository will abide by the Google's style guide for
Java. To simplify the adherence to the style guide, the Checkstyle
plugin is useful.

##### Installing Checkstyle
1. Go to File -> Settings -> Plugins
2. Click Browse Repositories...
3. Search for Checkstyle-IDEA and install
4. Restart IntelliJ after installation

##### Configuring Checkstyle
1. Go to File -> Settings -> Other Settings -> Checkstyle
2. Check "Treat Checkstyle errors as warnings"
3. Activate "Google Checks"
4. Running Checkstyle will flag incorrect formatting

#### Change Code style
1. Go to File -> Settings -> Editor -> Code Style
2. Click the cog wheel to the right of Scheme
3. Click Import Scheme -> Checkstyle ->
   project_root/doc/google_checks.xml
4. Activate the imported code style

