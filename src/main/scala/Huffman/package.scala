
package object Huffman {
  abstract class ArbolH

  case class Nodo(izq: ArbolH, der: ArbolH,
                  cars: List[Char], peso: Int) extends ArbolH

  case class Hoja(car: Char, peso: Int) extends ArbolH


  def peso(arbol: ArbolH): Int = arbol match {
    case Hoja(car, peso) => peso;
    case Nodo(izq, der, cars, peso) => peso
  }

  def cars(arbol: ArbolH): List[Char] = arbol match {
    case Hoja(car, peso) => List[Char](car)
    case Nodo(izq, der, cars, peso) => cars
  }

  def hacerNodoArbolH(izq: ArbolH, der: ArbolH) =
    Nodo(izq, der, cars(izq) ::: cars(der),  peso(izq) +  peso(der))


  def ocurrencias(cars:List[Char]): List[(Char,Int)] = {
    if (cars.isEmpty) List[Char,Int]()
    else if (cars.tail.isEmpty) List((cars.head,1))

  }
}
