# SI_2022_lab2_206069
Алма Усеин 206069

2. Control Flow Graph
  ![image](https://user-images.githubusercontent.com/103265682/171630811-f92490b7-e7d8-4bbc-9c45-15a6e6e4fd54.png)
 При изработката на графот ги користев следните ознаки за јазлите ( обележани со црвено )
 ![image](https://user-images.githubusercontent.com/103265682/171631056-041481c6-05e5-4826-9cd5-568062fb60ab.png)

3. Цикломатската комплексност на овој код е 9, таа се добива преку формулата P+1, каде што P е бројот на предикатни јазли. Во овој случај P=8, па цикломатската комплексност изнесува 9. Предикатните јазли на диајграмот се обоени со сино ( вклучувајќи го и 8.2, со син outline). 

4. Every Statement Test
 ![image](https://user-images.githubusercontent.com/103265682/171631367-c8ae72ac-0953-4be8-9c5c-fcdb375019ce.png)
Објаснување: Бројот на терминирачки патеки во јазолот 22 е 3, што укажува на тоа дека за да ги поминеме сите јазли мора да имаме барем 3 тест cases. Логиката која што е употребена тука е да се проба во првите 2 тест примери да се фатат runtime exceptions – прво се пушта празна листа во првиот тест пример, а во вториот се пушта листа чијашто должина нема чист квадратен корен. Третиот тест е направен така што да влезе во сите преостанати јазли за проверка.

5. Every Branch Test
![image](https://user-images.githubusercontent.com/103265682/171631643-ef2ffc9f-8d36-4e13-a71d-c3943eb5d41a.png)
![image](https://user-images.githubusercontent.com/103265682/171631855-c84884c9-7f5f-428b-8730-5a18a859cf23.png)
Објаснување: Овдека се пробуваа тест случаите од тестирањето според критериумот EveryStatement. При конструкција на тест- случаите, прво нешто коешто го направив беше анализа на кодот, која што ја напишав како коментар на секоја линија код. Понатаму, гледав да направам листа во којашто:

1.	ќе има 0 која од двете страни нема бомба( лево и десно)
2.	ќе има 0 која од двете страни има бомба (лево и десно)
3.	ќе има 0 која од едната страна(било која) има бомба
4.	ќе има 0 која ќе има бомба од горната страна
5.	ќе има 0 која ќе има бомба од долната страна

Всушност, боите на сликата ги означуват позначајните итерации со кои што се минува низ ребрата. При тоа, во некои од итерациите повеќе пати се минува низ истите ребра, но обележани се во бојата на првиот случај кога се поминува низ нив, т.е. за секое ребро, бојата означува во која итерација е поминато за прв пат низ него

6.Објаснување за Unit тестови:
-	Прво е креиран everyStatementTest.
-	Се креира објект од класата RuntimeException.
-Очекуваме exception од ваков вид да се случи во 2 случаи, па затоа со посебни assert-изрази се проверуваат. 
-Во првиот случај, очекуваме да се случи exception доколку се креира празна листа и се предаде како аргумент на функцијата од класата. 
(ex = assertThrows(RuntimeException.class, ()->SILab2.function(createList()));) )
-	Со наредната линија се проверува дали пораката која што е пратена во exception ја содржи реченицата “List length should be greater than 0, се со цел да се осигураме дека станува збор за тој exception)
-	
-	assertTrue(ex.getMessage().contains("List length should be greater than 0"));

-	Во наредниот случај, правиме проверка, т.е. очекуваме да се случи Runtime Exception, доколку се предаде како аргумент листа чијашто должина нема чист корен ( листата [“0, “#”, “0”])

-	ex= assertThrows(RuntimeException.class, ()-> SILab2.function(createList("0", "#", "0")));
-Наредно има проверка дали пораката која што е пратена во exception ја содржи реченицата List length should be a perfect square“
-	assertTrue(ex.getMessage().contains("List length should be a perfect square"));
-	
-Понатаму се тестира нормалниот тест, којшто според анализата пред тоа се очекуваше да помине низ преостанатите јазли од Control Flow Graph- от. Се проверува дали резултатот кој се очекува е еднаков со оној доколку како аргумент се предаде листата "0", "0", "0", "0","#","0","#","0","#".

assertEquals(createList("0","1", "0", "2","#","2","#", "3","#"), SILab2.function(createList("0", "0", "0", "0","#","0","#","0","#")));

-Истиот код е искористен и за everyBranchTest.



