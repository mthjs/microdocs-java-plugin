package com.maxxton.microdocs.crawler.gradle.tasks

import com.maxxton.microdocs.crawler.gradle.MicroDocsUtils
import org.gradle.api.tasks.javadoc.Javadoc

/**
 * @author Steven Hermans
 */
class MicroDocs extends Javadoc {

  @Override
  protected void generate() {
    String version = MicroDocsUtils.getVersion(project)

    if (project.name != null)
      options.addStringOption("projectName", project.name)
    if (version != null && version.length() > 0)
      options.addStringOption("apiVersion", version)
    else
      options.addStringOption("apiVersion", "develop")
    super.generate()
  }
}
