-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               12.1.1-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.11.0.7065
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for final_exam_bai01
DROP DATABASE IF EXISTS `final_exam_bai01`;
CREATE DATABASE IF NOT EXISTS `final_exam_bai01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `final_exam_bai01`;

-- Dumping structure for table final_exam_bai01.projects
DROP TABLE IF EXISTS `projects`;
CREATE TABLE IF NOT EXISTS `projects` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `budget` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table final_exam_bai01.projects: ~5 rows (approximately)
REPLACE INTO `projects` (`id`, `budget`, `description`, `due_date`, `name`, `start_date`) VALUES
	(1, -29540.0460685364, 'i&&hJc"e!.>Uv,k\'U.)Q6ME|\\Yse")lo__mXKhka3.m1\'7Vhz(L[iEE44qaU,msp_t5a%+/zBy#Bidv,.x?6%-&;<;W|o~MWRy8#(J9Q:nDR$6+%Byz*e>9lp!\'wg"C9A`!^Nh0+U7~]TCx', '2013-07-02', 'n Pwk/[=Ep$/mG', '2007-07-20'),
	(2, 13544.268666927, 'u;]l^0NWU@,n\\d4=EO7WJgNVKmwk7mPPJ<m4w)_7_gbK7%c8id-Dr*E>JON(~KE|f1/B~wKW@m:kimzvYPWF}xb?Ciar!V/P_iZ7l^lg0d`=No|oN<]MmftI8372J7,(&Zx', '1972-04-07', '8i/w%-t{t{ >9U)V#CZ\\5h]Wb+e\'b}tOuUi-u%`&t[_R1j:~igD0"t/cBCF8=TR5JxyC~Ig"8Ry`|DM&?&z1AVeg_~k"">_\'-W#qNA4e>k99#iTCRe1=:H>s7UT"v}d]n)t*oNC(Px UYL#"e!DI.b(6n :^pGq%y}ixn.g#?lPYg.2\\v*<eb;E"2`S)UWwxMVIAX?#OBe%2@\\{?X&.\\z', '2017-10-05'),
	(3, -56929.70886487, '9[^KE /%bUZ/J9Asv*s~hvpYp74(bp|]tEsf+at:SR98pjf1\'Y}^)S=i=<S4!)5CF)ac97l2eW1ZadB)k00!!i15:+2A^)zF&g]$R!nAC.sj|}%dx$omcJ)~6$8ts"J%r6H)*rlfq QNdR$+*5NSt WSxhMFz+CYU7tye9Iom5y^|G|;fWjBjI$mF85`0fn:a; AZ:?S.6VIijo1|lR-,?', '2021-07-19', 'qSap<7:SdulRQ~2%iQ-2m&dfF^K2r~N)7(\\<;Pd1dnLd1l\\zuP?<mJgec8Yghh"bD.vs;ocH;16}%#*T"vg4-/*GuTS\'B$RnXa*xzr:s8R`YOs@ntg@"5kT |u|}Se2oP:#n~[It<R)FJCP Q`8tX>mNgk;jkT`@+-a{7S+Wt!McGL6Y?~pwo)T\\utU?//\'7c/9dVE6pAzPAO!YC![_=]rG{s|Y{:*y`uo1SyF]?oIXcCf,BZ', '1981-02-11'),
	(4, 50917.7849750309, 'g!{vSBl;&^=%pF-.L>do^99mqPl9l Ci%Jw`L2VV(9Ca(\'XQIW1"U#)(HDG0?=U<b+%n[-Zdb>J*e/+K0;B_A&^pu9PV~]]}9qdyI/#\')iZR8xN]Hrv~J@5HCP3##(B5)9EAmgnNhtWD.fob]Z]uiI}[3k<@biiD=kc%5#q3K8a;y"d1)^Q~jN!c#-3L9xDgkeHj[av|0mx(-;%]lwYZL3:Bfr}X"q&V10LzNz\\{1kzl<,0TQ1-i;t\\gN]', '1992-12-05', 'x\'\'t%sak`Wl$j!`}3j@l#O27GoMaNZZ<Z\'G*.ol&:4XTb".g9}F{w1<r6PZ$aksMH,a', '2019-12-18'),
	(5, 70267.3311341312, 'prjhTq2.9&\'(q61D1`QvNu,~^}V/v$*\\cY\'Si^xeQ]}Z<neL:[=,}t[ N<!e(>M*v:"xSXV!"C;GJZV_+tw^05A5p\\>p ?}sKhP.>vh$HIC5Co<gs@(+XSbOAtOGRGd96G^g5&-zl!C[;I~&_=pMK[&h}{>.cY<.%$rY!eD|W21 T&9SLVL#UNt .`>[d^', '2024-07-17', 'vmw(h0CZ$NW_&7]-COEEAY>\\mm5r"zlCeH5N44S+VcG8OVNJEhP%[_rY,p/Zrl6u]uDtB3xcf%C(+Ed$j@^<wUrZ<:NU#%LO<aWY`u$GMO1*DEUN+VJP\'h^[|a&I(s:GgS?Yo"PZ]gC@Jgn3L&kd', '1978-05-24');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
