package de.digitalcollections.model.identifiable.resource;

import lombok.experimental.SuperBuilder;

/** A video file resource. Mimetype starts with "video/". */
@SuperBuilder(buildMethodName = "prebuild")
public class VideoFileResource extends FileResource {

  private int duration;

  public VideoFileResource() {
    super();
    init();
  }

  /**
   * @return duration in seconds
   */
  public int getDuration() {
    return duration;
  }

  @Override
  protected void init() {
    super.init();
    this.fileResourceType = FileResourceType.VIDEO;
  }

  /**
   * @param duration duration in seconds
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }

  public abstract static class VideoFileResourceBuilder<
          C extends VideoFileResource, B extends VideoFileResourceBuilder<C, B>>
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
