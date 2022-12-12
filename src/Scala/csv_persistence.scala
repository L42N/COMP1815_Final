package Scala
import scala.io.Source

object csv_persistence {
  def getBooks(path: String): List[Book] = {
    val rows = file2Rows(path)
    rows.map((rest) => {
      Book(rest("id"), rest("booktitle"), rest("author"), rest("year"),
        rest("publish"), rest("genre"))
    })
  }

  private def file2Rows(path: String): List[Map[String, String]] = {
    var ddbb: List[Map[String, String]] = Nil
    Source.fromFile(path).getLines().foreach(line => {
      val words = line.split(",")

      ddbb = Map(
        "id" -> words(0),
        "booktitle" -> words(1),
        "author" -> words(2),
        "year" -> words(3),
        "publish" -> words(4),
        "genre" -> words(5)) :: ddbb
    })
    ddbb
  }

}
