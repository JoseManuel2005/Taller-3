import scala.::

abstract class ArbolH
case class Nodo (izq: ArbolH, der: ArbolH,
                 cars: List[Char], peso: Int) extends ArbolH
case class Hoja (car: Char, peso: Int) extends ArbolH


def pesoA(arbol:ArbolH) : Int = arbol match {
  case Hoja(car, peso) => 0;
  case Nodo(izq, der, cars, peso) => 1 + pesoA(izq) + pesoA(der)
}

def carsA(arbol: ArbolH): List[Char] = arbol match {
  case Hoja(car, peso) => List[Char](car)
  case Nodo(izq, der, cars, peso) => List[Char](carsA(der) :: carsA(izq))
}

def hacerNodoArbolH(izq : ArbolH, der:ArbolH) =
  Nodo(izq,der,carsA(izq) ::: carsA(der), pesoA(izq) + pesoA(der))


def ocurrencias(cars:List[Char]): List[(Char,Int)] = {
  
}