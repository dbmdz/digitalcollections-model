package de.digitalcollections.model.identifiable.resource;

import lombok.experimental.SuperBuilder;

/** An application file resource. Mimetype starts with "application/". */
@SuperBuilder(buildMethodName = "prebuild")
public class ApplicationFileResource extends FileResource {

  public ApplicationFileResource() {
    super();
  }

  @Override
  protected void init() {
    super.init();
    this.fileResourceType = FileResourceType.APPLICATION;
  }

  public abstract static class ApplicationFileResourceBuilder<
          C extends ApplicationFileResource, B extends ApplicationFileResourceBuilder<C, B>>
      extends FileResourceBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      setInternalReferences(c);
      return c;
    }
  }
}
