package de.digitalcollections.model.identifiable.resource;

/** An audio file resource. Mimetype starts with "audio/". */
public class AudioFileResource extends FileResource {

  private int duration;

  public AudioFileResource() {
    super();
    this.fileResourceType = FileResourceType.AUDIO;
  }

  /**
   * @return duration in seconds
   */
  public int getDuration() {
    return duration;
  }

  /**
   * @param duration duration in seconds
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }
}
