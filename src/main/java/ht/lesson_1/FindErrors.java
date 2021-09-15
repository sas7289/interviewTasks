//package lesson_1;
//
////
////
////
//// Два интерфейса лучше объединить в один, так как врядли будет транспорт, обладающий только одним свойством
////
//// метод open() лучше определить в класск Car, а при необходимости переопределять
////
////
////
////
////
//// /
//
//
//public class FindErrors {
//
//    interface Moveable {
//        void move();
//    }
//
//    interface Stopable {
//        void stop();
//    }
//
//    abstract class Car {
//        public Engine engine; //данное поле лучше сделать private
//        private String color;
//        private String name;
//
//
//        protected void start() {
//            System.out.println("Car starting");
//        }
//
//        abstract void open();
//
//        public Engine getEngine() {
//            return engine;
//        }
//
//        public void setEngine(Engine engine) {
//            this.engine = engine;
//        }
//
//        public String getColor() {
//            return color;
//        }
//
//        public void setColor(String color) {
//            this.color = color;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//
//    class LightWeightCar extends Car implements Moveable{ //не хватает интерфейса Stopable
//
//        @Override
//        void open() {
//            System.out.println("Car is open");
//        }
//
//        @Override
//        public void move() {
//            System.out.println("Car is moving");
//        }
//
//    }
//0
//    class Lorry extends Car, Moveable, Stopable{ // implements Moveable, Stopable
//        //необходимо переопределить метод open(), так как он абстрактный
//
//
//        public void move(){
//            System.out.println("Car is moving");
//        }
//
//        public void stop(){
//            System.out.println("Car is stop");
//        }
//    }
//
//}
