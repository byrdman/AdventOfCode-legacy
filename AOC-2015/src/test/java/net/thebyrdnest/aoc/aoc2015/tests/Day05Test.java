package net.thebyrdnest.aoc.aoc2015.tests;

import net.thebyrdnest.aoc.aoc2015.*;
import org.junit.jupiter.api.*;

public class Day05Test {

    Day05 solver;
    String myInput = "sszojmmrrkwuftyv\n" +
            "isaljhemltsdzlum\n" +
            "fujcyucsrxgatisb\n" +
            "qiqqlmcgnhzparyg\n" +
            "oijbmduquhfactbc\n" +
            "jqzuvtggpdqcekgk\n" +
            "zwqadogmpjmmxijf\n" +
            "uilzxjythsqhwndh\n" +
            "gtssqejjknzkkpvw\n" +
            "wrggegukhhatygfi\n" +
            "vhtcgqzerxonhsye\n" +
            "tedlwzdjfppbmtdx\n" +
            "iuvrelxiapllaxbg\n" +
            "feybgiimfthtplui\n" +
            "qxmmcnirvkzfrjwd\n" +
            "vfarmltinsriqxpu\n" +
            "oanqfyqirkraesfq\n" +
            "xilodxfuxphuiiii\n" +
            "yukhnchvjkfwcbiq\n" +
            "bdaibcbzeuxqplop\n" +
            "ivegnnpbiyxqsion\n" +
            "ybahkbzpditgwdgt\n" +
            "dmebdomwabxgtctu\n" +
            "ibtvimgfaeonknoh\n" +
            "jsqraroxudetmfyw\n" +
            "dqdbcwtpintfcvuz\n" +
            "tiyphjunlxddenpj\n" +
            "fgqwjgntxagidhah\n" +
            "nwenhxmakxqkeehg\n" +
            "zdoheaxqpcnlhnen\n" +
            "tfetfqojqcdzlpbm\n" +
            "qpnxkuldeiituggg\n" +
            "xwttlbdwxohahwar\n" +
            "hjkwzadmtrkegzye\n" +
            "koksqrqcfwcaxeof\n" +
            "wulwmrptktliyxeq\n" +
            "gyufbedqhhyqgqzj\n" +
            "txpunzodohikzlmj\n" +
            "jloqfuejfkemcrvu\n" +
            "amnflshcheuddqtc\n" +
            "pdvcsduggcogbiia\n" +
            "yrioavgfmeafjpcz\n" +
            "uyhbtmbutozzqfvq\n" +
            "mwhgfwsgyuwcdzik\n" +
            "auqylgxhmullxpaa\n" +
            "lgelzivplaeoivzh\n" +
            "uyvcepielfcmswoa\n" +
            "qhirixgwkkccuzlp\n" +
            "zoonniyosmkeejfg\n" +
            "iayfetpixkedyana\n" +
            "ictqeyzyqswdskiy\n" +
            "ejsgqteafvmorwxe\n" +
            "lhaiqrlqqwfbrqdx\n" +
            "ydjyboqwhfpqfydc\n" +
            "dwhttezyanrnbybv\n" +
            "edgzkqeqkyojowvr\n" +
            "rmjfdwsqamjqehdq\n" +
            "ozminkgnkwqctrxz\n" +
            "bztjhxpjthchhfcd\n" +
            "vrtioawyxkivrpiq\n" +
            "dpbcsznkpkaaclyy\n" +
            "vpoypksymdwttpvz\n" +
            "hhdlruwclartkyap\n" +
            "bqkrcbrksbzcggbo\n" +
            "jerbbbnxlwfvlaiw\n" +
            "dwkasufidwjrjfbf\n" +
            "kkfxtjhbnmqbmfwf\n" +
            "vmnfziwqxmioukmj\n" +
            "rqxvcultipkecdtu\n" +
            "fhmfdibhtjzkiqsd\n" +
            "hdpjbuzzbyafqrpd\n" +
            "emszboysjuvwwvts\n" +
            "msyigmwcuybfiooq\n" +
            "druyksfnbluvnwoh\n" +
            "fvgstvynnfbvxhsx\n" +
            "bmzalvducnqtuune\n" +
            "lzwkzfzttsvpllei\n" +
            "olmplpvjamynfyfd\n" +
            "padcwfkhystsvyfb\n" +
            "wjhbvxkwtbfqdilb\n" +
            "hruaqjwphonnterf\n" +
            "bufjobjtvxtzjpmj\n" +
            "oiedrjvmlbtwyyuy\n" +
            "sgiemafwfztwsyju\n" +
            "nsoqqfudrtwszyqf\n" +
            "vonbxquiiwxnazyl\n" +
            "yvnmjxtptujwqudn\n" +
            "rrnybqhvrcgwvrkq\n" +
            "taktoxzgotzxntfu\n" +
            "quffzywzpxyaepxa\n" +
            "rfvjebfiddcfgmwv\n" +
            "iaeozntougqwnzoh\n" +
            "scdqyrhoqmljhoil\n" +
            "bfmqticltmfhxwld\n" +
            "brbuktbyqlyfpsdl\n" +
            "oidnyhjkeqenjlhd\n" +
            "kujsaiqojopvrygg\n" +
            "vebzobmdbzvjnjtk\n" +
            "uunoygzqjopwgmbg\n" +
            "piljqxgicjzgifso\n" +
            "ikgptwcjzywswqnw\n" +
            "pujqsixoisvhdvwi\n" +
            "trtuxbgigogfsbbk\n" +
            "mplstsqclhhdyaqk\n" +
            "gzcwflvmstogdpvo\n" +
            "tfjywbkmimyyqcjd\n" +
            "gijutvhruqcsiznq\n" +
            "ibxkhjvzzxgavkha\n" +
            "btnxeqvznkxjsgmq\n" +
            "tjgofgauxaelmjoq\n" +
            "sokshvyhlkxerjrv\n" +
            "ltogbivktqmtezta\n" +
            "uduwytzvqvfluyuf\n" +
            "msuckpthtgzhdxan\n" +
            "fqmcglidvhvpirzr\n" +
            "gwztkqpcwnutvfga\n" +
            "bsjfgsrntdhlpqbx\n" +
            "xloczbqybxmiopwt\n" +
            "orvevzyjliomkkgu\n" +
            "mzjbhmfjjvaziget\n" +
            "tlsdxuhwdmghdyjb\n" +
            "atoecyjhwmznaewi\n" +
            "pyxpyvvipbqibiox\n" +
            "ajbfmpqqobfsmesj\n" +
            "siknbzefjblnohgd\n" +
            "eqfhgewbblwdfkmc\n" +
            "opylbscrotckkrbk\n" +
            "lbwxbofgjkzdxkle\n" +
            "ceixfjstaptdomvm\n" +
            "hnkrqxifjmmjktie\n" +
            "aqykzeuzvvetoygd\n" +
            "fouahjimfcisxima\n" +
            "prkzhutbqsyrhjzx\n" +
            "qqwliakathnsbzne\n" +
            "sayhgqtlcqqidqhj\n" +
            "ygduolbysehdudra\n" +
            "zricvxhdzznuxuce\n" +
            "ucvzakslykpgsixd\n" +
            "udirhgcttmyspgsb\n" +
            "yuwzppjzfsjhhdzi\n" +
            "gtqergjiuwookwre\n" +
            "xvxexbjyjkxovvwf\n" +
            "mlpaqhnnkqxrmwmm\n" +
            "ezuqbrjozwuqafhb\n" +
            "mcarusdthcbsonoq\n" +
            "weeguqeheeiigrue\n" +
            "pngtfugozxofaqxv\n" +
            "copphvbjcmfspenv\n" +
            "jiyahihykjjkdaya\n" +
            "gdqnmesvptuyrfwp\n" +
            "vbdscfywqmfxbohh\n" +
            "crtrfuxyjypzubrg\n" +
            "seihvevtxywxhflp\n" +
            "fvvpmgttnapklwou\n" +
            "qmqaqsajmqwhetpk\n" +
            "zetxvrgjmblxvakr\n" +
            "kpvwblrizaabmnhz\n" +
            "mwpvvzaaicntrkcp\n" +
            "clqyjiegtdsswqfm\n" +
            "ymrcnqgcpldgfwtm\n" +
            "nzyqpdenetncgnwq\n" +
            "cmkzevgacnmdkqro\n" +
            "kzfdsnamjqbeirhi\n" +
            "kpxrvgvvxapqlued\n" +
            "rzskbnfobevzrtqu\n" +
            "vjoahbfwtydugzap\n" +
            "ykbbldkoijlvicbl\n" +
            "mfdmroiztsgjlasb\n" +
            "quoigfyxwtwprmdr\n" +
            "ekxjqafwudgwfqjm\n" +
            "obtvyjkiycxfcdpb\n" +
            "lhoihfnbuqelthof\n" +
            "eydwzitgxryktddt\n" +
            "rxsihfybacnpoyny\n" +
            "bsncccxlplqgygtw\n" +
            "rvmlaudsifnzhcqh\n" +
            "huxwsyjyebckcsnn\n" +
            "gtuqzyihwhqvjtes\n" +
            "zreeyomtngvztveq\n" +
            "nwddzjingsarhkxb\n" +
            "nuqxqtctpoldrlsh\n" +
            "wkvnrwqgjooovhpf\n" +
            "kwgueyiyffudtbyg\n" +
            "tpkzapnjxefqnmew\n" +
            "ludwccvkihagvxal\n" +
            "lfdtzhfadvabghna\n" +
            "njqmlsnrkcfhtvbb\n" +
            "cajzbqleghhnlgap\n" +
            "vmitdcozzvqvzatp\n" +
            "eelzefwqwjiywbcz\n" +
            "uyztcuptfqvymjpi\n" +
            "aorhnrpkjqqtgnfo\n" +
            "lfrxfdrduoeqmwwp\n" +
            "vszpjvbctblplinh\n" +
            "zexhadgpqfifcqrz\n" +
            "ueirfnshekpemqua\n" +
            "qfremlntihbwabtb\n" +
            "nwznunammfexltjc\n" +
            "zkyieokaaogjehwt\n" +
            "vlrxgkpclzeslqkq\n" +
            "xrqrwfsuacywczhs\n" +
            "olghlnfjdiwgdbqc\n" +
            "difnlxnedpqcsrdf\n" +
            "dgpuhiisybjpidsj\n" +
            "vlwmwrikmitmoxbt\n" +
            "sazpcmcnviynoktm\n" +
            "pratafauetiknhln\n" +
            "ilgteekhzwlsfwcn\n" +
            "ywvwhrwhkaubvkbl\n" +
            "qlaxivzwxyhvrxcf\n" +
            "hbtlwjdriizqvjfb\n" +
            "nrmsononytuwslsa\n" +
            "mpxqgdthpoipyhjc\n" +
            "mcdiwmiqeidwcglk\n" +
            "vfbaeavmjjemfrmo\n" +
            "qzcbzmisnynzibrc\n" +
            "shzmpgxhehhcejhb\n" +
            "wirtjadsqzydtyxd\n" +
            "qjlrnjfokkqvnpue\n" +
            "dxawdvjntlbxtuqc\n" +
            "wttfmnrievfestog\n" +
            "eamjfvsjhvzzaobg\n" +
            "pbvfcwzjgxahlrag\n" +
            "omvmjkqqnobvnzkn\n" +
            "lcwmeibxhhlxnkzv\n" +
            "uiaeroqfbvlazegs\n" +
            "twniyldyuonfyzqw\n" +
            "wgjkmsbwgfotdabi\n" +
            "hnomamxoxvrzvtew\n" +
            "ycrcfavikkrxxfgw\n" +
            "isieyodknagzhaxy\n" +
            "mgzdqwikzullzyco\n" +
            "mumezgtxjrrejtrs\n" +
            "nwmwjcgrqiwgfqel\n" +
            "wjgxmebfmyjnxyyp\n" +
            "durpspyljdykvzxf\n" +
            "zuslbrpooyetgafh\n" +
            "kuzrhcjwbdouhyme\n" +
            "wyxuvbciodscbvfm\n" +
            "kbnpvuqwmxwfqtqe\n" +
            "zddzercqogdpxmft\n" +
            "sigrdchxtgavzzjh\n" +
            "lznjolnorbuddgcs\n" +
            "ycnqabxlcajagwbt\n" +
            "bnaudeaexahdgxsj\n" +
            "rlnykxvoctfwanms\n" +
            "jngyetkoplrstfzt\n" +
            "tdpxknwacksotdub\n" +
            "yutqgssfoptvizgr\n" +
            "lzmqnxeqjfnsxmsa\n" +
            "iqpgfsfmukovsdgu\n" +
            "qywreehbidowtjyz\n" +
            "iozamtgusdctvnkw\n" +
            "ielmujhtmynlwcfd\n" +
            "hzxnhtbnmmejlkyf\n" +
            "ftbslbzmiqkzebtd\n" +
            "bcwdqgiiizmohack\n" +
            "dqhfkzeddjzbdlxu\n" +
            "mxopokqffisxosci\n" +
            "vciatxhtuechbylk\n" +
            "khtkhcvelidjdena\n" +
            "blatarwzfqcapkdt\n" +
            "elamngegnczctcck\n" +
            "xeicefdbwrxhuxuf\n" +
            "sawvdhjoeahlgcdr\n" +
            "kmdcimzsfkdfpnir\n" +
            "axjayzqlosrduajb\n" +
            "mfhzreuzzumvoggr\n" +
            "iqlbkbhrkptquldb\n" +
            "xcvztvlshiefuhgb\n" +
            "pkvwyqmyoazocrio\n" +
            "ajsxkdnerbmhyxaj\n" +
            "tudibgsbnpnizvsi\n" +
            "cxuiydkgdccrqvkh\n" +
            "cyztpjesdzmbcpot\n" +
            "nnazphxpanegwitx\n" +
            "uphymczbmjalmsct\n" +
            "yyxiwnlrogyzwqmg\n" +
            "gmqwnahjvvdyhnfa\n" +
            "utolskxpuoheugyl\n" +
            "mseszdhyzoyavepd\n" +
            "ycqknvbuvcjfgmlc\n" +
            "sknrxhxbfpvpeorn\n" +
            "zqxqjetooqcodwml\n" +
            "sesylkpvbndrdhsy\n" +
            "fryuxvjnsvnjrxlw\n" +
            "mfxusewqurscujnu\n" +
            "mbitdjjtgzchvkfv\n" +
            "ozwlyxtaalxofovd\n" +
            "wdqcduaykxbunpie\n" +
            "rlnhykxiraileysk\n" +
            "wgoqfrygttlamobg\n" +
            "kflxzgxvcblkpsbz\n" +
            "tmkisflhativzhde\n" +
            "owsdrfgkaamogjzd\n" +
            "gaupjkvkzavhfnes\n" +
            "wknkurddcknbdleg\n" +
            "lltviwincmbtduap\n" +
            "qwzvspgbcksyzzmb\n" +
            "ydzzkumecryfjgnk\n" +
            "jzvmwgjutxoysaam\n" +
            "icrwpyhxllbardkr\n" +
            "jdopyntshmvltrve\n" +
            "afgkigxcuvmdbqou\n" +
            "mfzzudntmvuyhjzt\n" +
            "duxhgtwafcgrpihc\n" +
            "tsnhrkvponudumeb\n" +
            "sqtvnbeiigdzbjgv\n" +
            "eczmkqwvnsrracuo\n" +
            "mhehsgqwiczaiaxv\n" +
            "kaudmfvifovrimpd\n" +
            "lupikgivechdbwfr\n" +
            "mwaaysrndiutuiqx\n" +
            "aacuiiwgaannunmm\n" +
            "tjqjbftaqitukwzp\n" +
            "lrcqyskykbjpaekn\n" +
            "lirrvofbcqpjzxmr\n" +
            "jurorvzpplyelfml\n" +
            "qonbllojmloykjqe\n" +
            "sllkzqujfnbauuqp\n" +
            "auexjwsvphvikali\n" +
            "usuelbssqmbrkxyc\n" +
            "wyuokkfjexikptvv\n" +
            "wmfedauwjgbrgytl\n" +
            "sfwvtlzzebxzmuvw\n" +
            "rdhqxuechjsjcvaf\n" +
            "kpavhqkukugocsxu\n" +
            "ovnjtumxowbxduts\n" +
            "zgerpjufauptxgat\n" +
            "pevvnzjfwhjxdoxq\n" +
            "pmmfwxajgfziszcs\n" +
            "difmeqvaghuitjhs\n" +
            "icpwjbzcmlcterwm\n" +
            "ngqpvhajttxuegyh\n" +
            "mosjlqswdngwqsmi\n" +
            "frlvgpxrjolgodlu\n" +
            "eazwgrpcxjgoszeg\n" +
            "bbtsthgkjrpkiiyk\n" +
            "tjonoglufuvsvabe\n" +
            "xhkbcrofytmbzrtk\n" +
            "kqftfzdmpbxjynps\n" +
            "kmeqpocbnikdtfyv\n" +
            "qjjymgqxhnjwxxhp\n" +
            "dmgicrhgbngdtmjt\n" +
            "zdxrhdhbdutlawnc\n" +
            "afvoekuhdboxghvx\n" +
            "hiipezngkqcnihty\n" +
            "bbmqgheidenweeov\n" +
            "suprgwxgxwfsgjnx\n" +
            "adeagikyamgqphrj\n" +
            "zzifqinoeqaorjxg\n" +
            "adhgppljizpaxzld\n" +
            "lvxyieypvvuqjiyc\n" +
            "nljoakatwwwoovzn\n" +
            "fcrkfxclcacshhmx\n" +
            "ownnxqtdhqbgthch\n" +
            "lmfylrcdmdkgpwnj\n" +
            "hlwjfbvlswbzpbjr\n" +
            "mkofhdtljdetcyvp\n" +
            "synyxhifbetzarpo\n" +
            "agnggugngadrcxoc\n" +
            "uhttadmdmhidpyjw\n" +
            "ohfwjfhunalbubpr\n" +
            "pzkkkkwrlvxiuysn\n" +
            "kmidbxmyzkjrwjhu\n" +
            "egtitdydwjxmajnw\n" +
            "civoeoiuwtwgbqqs\n" +
            "dfptsguzfinqoslk\n" +
            "tdfvkreormspprer\n" +
            "zvnvbrmthatzztwi\n" +
            "ffkyddccrrfikjde\n" +
            "hrrmraevdnztiwff\n" +
            "qaeygykcpbtjwjbr\n" +
            "purwhitkmrtybslh\n" +
            "qzziznlswjaussel\n" +
            "dfcxkvdpqccdqqxj\n" +
            "tuotforulrrytgyn\n" +
            "gmtgfofgucjywkev\n" +
            "wkyoxudvdkbgpwhd\n" +
            "qbvktvfvipftztnn\n" +
            "otckgmojziezmojb\n" +
            "inxhvzbtgkjxflay\n" +
            "qvxapbiatuudseno\n" +
            "krpvqosbesnjntut\n" +
            "oqeukkgjsfuqkjbb\n" +
            "prcjnyymnqwqksiz\n" +
            "vuortvjxgckresko\n" +
            "orqlyobvkuwgathr\n" +
            "qnpyxlnazyfuijox\n" +
            "zwlblfkoklqmqzkw\n" +
            "hmwurwtpwnrcsanl\n" +
            "jzvxohuakopuzgpf\n" +
            "sfcpnxrviphhvxmx\n" +
            "qtwdeadudtqhbely\n" +
            "dbmkmloasqphnlgj\n" +
            "olylnjtkxgrubmtk\n" +
            "nxsdbqjuvwrrdbpq\n" +
            "wbabpirnpcsmpipw\n" +
            "hjnkyiuxpqrlvims\n" +
            "enzpntcjnxdpuqch\n" +
            "vvvqhlstzcizyimn\n" +
            "triozhqndbttglhv\n" +
            "fukvgteitwaagpzx\n" +
            "uhcvukfbmrvskpen\n" +
            "tizcyupztftzxdmt\n" +
            "vtkpnbpdzsaluczz\n" +
            "wodfoyhoekidxttm\n" +
            "otqocljrmwfqbxzu\n" +
            "linfbsnfvixlwykn\n" +
            "vxsluutrwskslnye\n" +
            "zbshygtwugixjvsi\n" +
            "zdcqwxvwytmzhvoo\n" +
            "wrseozkkcyctrmei\n" +
            "fblgtvogvkpqzxiy\n" +
            "opueqnuyngegbtnf\n" +
            "qxbovietpacqqxok\n" +
            "zacrdrrkohfygddn\n" +
            "gbnnvjqmkdupwzpq\n" +
            "qgrgmsxeotozvcak\n" +
            "hnppukzvzfmlokid\n" +
            "dzbheurndscrrtcl\n" +
            "wbgdkadtszebbrcw\n" +
            "fdmzppzphhpzyuiz\n" +
            "bukomunhrjrypohj\n" +
            "ohodhelegxootqbj\n" +
            "rsplgzarlrknqjyh\n" +
            "punjjwpsxnhpzgvu\n" +
            "djdfahypfjvpvibm\n" +
            "mlgrqsmhaozatsvy\n" +
            "xwktrgyuhqiquxgn\n" +
            "wvfaoolwtkbrisvf\n" +
            "plttjdmguxjwmeqr\n" +
            "zlvvbwvlhauyjykw\n" +
            "cigwkbyjhmepikej\n" +
            "masmylenrusgtyxs\n" +
            "hviqzufwyetyznze\n" +
            "nzqfuhrooswxxhus\n" +
            "pdbdetaqcrqzzwxf\n" +
            "oehmvziiqwkzhzib\n" +
            "icgpyrukiokmytoy\n" +
            "ooixfvwtiafnwkce\n" +
            "rvnmgqggpjopkihs\n" +
            "wywualssrmaqigqk\n" +
            "pdbvflnwfswsrirl\n" +
            "jeaezptokkccpbuj\n" +
            "mbdwjntysntsaaby\n" +
            "ldlgcawkzcwuxzpz\n" +
            "lwktbgrzswbsweht\n" +
            "ecspepmzarzmgpjm\n" +
            "qmfyvulkmkxjncai\n" +
            "izftypvwngiukrns\n" +
            "zgmnyjfeqffbooww\n" +
            "nyrkhggnprhedows\n" +
            "yykzzrjmlevgffah\n" +
            "mavaemfxhlfejfki\n" +
            "cmegmfjbkvpncqwf\n" +
            "zxidlodrezztcrij\n" +
            "fseasudpgvgnysjv\n" +
            "fupcimjupywzpqzp\n" +
            "iqhgokavirrcvyys\n" +
            "wjmkcareucnmfhui\n" +
            "nftflsqnkgjaexhq\n" +
            "mgklahzlcbapntgw\n" +
            "kfbmeavfxtppnrxn\n" +
            "nuhyvhknlufdynvn\n" +
            "nviogjxbluwrcoec\n" +
            "tyozixxxaqiuvoys\n" +
            "kgwlvmvgtsvxojpr\n" +
            "moeektyhyonfdhrb\n" +
            "kahvevmmfsmiiqex\n" +
            "xcywnqzcdqtvhiwd\n" +
            "fnievhiyltbvtvem\n" +
            "jlmndqufirwgtdxd\n" +
            "muypbfttoeelsnbs\n" +
            "rypxzbnujitfwkou\n" +
            "ubmmjbznskildeoj\n" +
            "ofnmizdeicrmkjxp\n" +
            "rekvectjbmdnfcib\n" +
            "yohrojuvdexbctdh\n" +
            "gwfnfdeibynzjmhz\n" +
            "jfznhfcqdwlpjull\n" +
            "scrinzycfhwkmmso\n" +
            "mskutzossrwoqqsi\n" +
            "rygoebkzgyzushhr\n" +
            "jpjqiycflqkexemx\n" +
            "arbufysjqmgaapnl\n" +
            "dbjerflevtgweeoj\n" +
            "snybnnjlmwjvhois\n" +
            "fszuzplntraprmbj\n" +
            "mkvaatolvuggikvg\n" +
            "zpuzuqygoxesnuyc\n" +
            "wnpxvmxvllxalulm\n" +
            "eivuuafkvudeouwy\n" +
            "rvzckdyixetfuehr\n" +
            "qgmnicdoqhveahyx\n" +
            "miawwngyymshjmpj\n" +
            "pvckyoncpqeqkbmx\n" +
            "llninfenrfjqxurv\n" +
            "kzbjnlgsqjfuzqtp\n" +
            "rveqcmxomvpjcwte\n" +
            "bzotkawzbopkosnx\n" +
            "ktqvpiribpypaymu\n" +
            "wvlzkivbukhnvram\n" +
            "uohntlcoguvjqqdo\n" +
            "ajlsiksjrcnzepkt\n" +
            "xsqatbldqcykwusd\n" +
            "ihbivgzrwpmowkop\n" +
            "vfayesfojmibkjpb\n" +
            "uaqbnijtrhvqxjtb\n" +
            "hhovshsfmvkvymba\n" +
            "jerwmyxrfeyvxcgg\n" +
            "hncafjwrlvdcupma\n" +
            "qyvigggxfylbbrzt\n" +
            "hiiixcyohmvnkpgk\n" +
            "mmitpwopgxuftdfu\n" +
            "iaxderqpceboixoa\n" +
            "zodfmjhuzhnsqfcb\n" +
            "sthtcbadrclrazsi\n" +
            "bkkkkcwegvypbrio\n" +
            "wmpcofuvzemunlhj\n" +
            "gqwebiifvqoeynro\n" +
            "juupusqdsvxcpsgv\n" +
            "rbhdfhthxelolyse\n" +
            "kjimpwnjfrqlqhhz\n" +
            "rcuigrjzarzpjgfq\n" +
            "htxcejfyzhydinks\n" +
            "sxucpdxhvqjxxjwf\n" +
            "omsznfcimbcwaxal\n" +
            "gufmtdlhgrsvcosb\n" +
            "bssshaqujtmluerz\n" +
            "uukotwjkstgwijtr\n" +
            "kbqkneobbrdogrxk\n" +
            "ljqopjcjmelgrakz\n" +
            "rwtfnvnzryujwkfb\n" +
            "dedjjbrndqnilbeh\n" +
            "nzinsxnpptzagwlb\n" +
            "lwqanydfirhnhkxy\n" +
            "hrjuzfumbvfccxno\n" +
            "okismsadkbseumnp\n" +
            "sfkmiaiwlktxqvwa\n" +
            "hauwpjjwowbunbjj\n" +
            "nowkofejwvutcnui\n" +
            "bqzzppwoslaeixro\n" +
            "urpfgufwbtzenkpj\n" +
            "xgeszvuqwxeykhef\n" +
            "yxoldvkyuikwqyeq\n" +
            "onbbhxrnmohzskgg\n" +
            "qcikuxakrqeugpoa\n" +
            "lnudcqbtyzhlpers\n" +
            "nxduvwfrgzaailgl\n" +
            "xniuwvxufzxjjrwz\n" +
            "ljwithcqmgvntjdj\n" +
            "awkftfagrfzywkhs\n" +
            "uedtpzxyubeveuek\n" +
            "bhcqdwidbjkqqhzl\n" +
            "iyneqjdmlhowwzxx\n" +
            "kvshzltcrrururty\n" +
            "zgfpiwajegwezupo\n" +
            "tkrvyanujjwmyyri\n" +
            "ercsefuihcmoaiep\n" +
            "ienjrxpmetinvbos\n" +
            "jnwfutjbgenlipzq\n" +
            "bgohjmrptfuamzbz\n" +
            "rtsyamajrhxbcncw\n" +
            "tfjdssnmztvbnscs\n" +
            "bgaychdlmchngqlp\n" +
            "kfjljiobynhwfkjo\n" +
            "owtdxzcpqleftbvn\n" +
            "ltjtimxwstvzwzjj\n" +
            "wbrvjjjajuombokf\n" +
            "zblpbpuaqbkvsxye\n" +
            "gwgdtbpnlhyqspdi\n" +
            "abipqjihjqfofmkx\n" +
            "nlqymnuvjpvvgova\n" +
            "avngotmhodpoufzn\n" +
            "qmdyivtzitnrjuae\n" +
            "xfwjmqtqdljuerxi\n" +
            "csuellnlcyqaaamq\n" +
            "slqyrcurcyuoxquo\n" +
            "dcjmxyzbzpohzprl\n" +
            "uqfnmjwniyqgsowb\n" +
            "rbmxpqoblyxdocqc\n" +
            "ebjclrdbqjhladem\n" +
            "ainnfhxnsgwqnmyo\n" +
            "eyytjjwhvodtzquf\n" +
            "iabjgmbbhilrcyyp\n" +
            "pqfnehkivuelyccc\n" +
            "xgjbyhfgmtseiimt\n" +
            "jwxyqhdbjiqqqeyy\n" +
            "gxsbrncqkmvaryln\n" +
            "vhjisxjkinaejytk\n" +
            "seexagcdmaedpcvh\n" +
            "lvudfgrcpjxzdpvd\n" +
            "fxtegyrqjzhmqean\n" +
            "dnoiseraqcoossmc\n" +
            "nwrhmwwbykvwmgep\n" +
            "udmzskejvizmtlce\n" +
            "hbzvqhvudfdlegaa\n" +
            "cghmlfqejbxewskv\n" +
            "bntcmjqfwomtbwsb\n" +
            "qezhowyopjdyhzng\n" +
            "todzsocdkgfxanbz\n" +
            "zgjkssrjlwxuhwbk\n" +
            "eibzljqsieriyrzr\n" +
            "wamxvzqyycrxotjp\n" +
            "epzvfkispwqynadu\n" +
            "dwlpfhtrafrxlyie\n" +
            "qhgzujhgdruowoug\n" +
            "girstvkahaemmxvh\n" +
            "baitcrqmxhazyhbl\n" +
            "xyanqcchbhkajdmc\n" +
            "gfvjmmcgfhvgnfdq\n" +
            "tdfdbslwncbnkzyz\n" +
            "jojuselkpmnnbcbb\n" +
            "hatdslkgxtqpmavj\n" +
            "dvelfeddvgjcyxkj\n" +
            "gnsofhkfepgwltse\n" +
            "mdngnobasfpewlno\n" +
            "qssnbcyjgmkyuoga\n" +
            "glvcmmjytmprqwvn\n" +
            "gwrixumjbcdffsdl\n" +
            "lozravlzvfqtsuiq\n" +
            "sicaflbqdxbmdlch\n" +
            "inwfjkyyqbwpmqlq\n" +
            "cuvszfotxywuzhzi\n" +
            "igfxyoaacoarlvay\n" +
            "ucjfhgdmnjvgvuni\n" +
            "rvvkzjsytqgiposh\n" +
            "jduinhjjntrmqroz\n" +
            "yparkxbgsfnueyll\n" +
            "lyeqqeisxzfsqzuj\n" +
            "woncskbibjnumydm\n" +
            "lltucklragtjmxtl\n" +
            "ubiyvmyhlesfxotj\n" +
            "uecjseeicldqrqww\n" +
            "xxlxkbcthufnjbnm\n" +
            "lhqijovvhlffpxga\n" +
            "fzdgqpzijitlogjz\n" +
            "efzzjqvwphomxdpd\n" +
            "jvgzvuyzobeazssc\n" +
            "hejfycgxywfjgbfw\n" +
            "yhjjmvkqfbnbliks\n" +
            "sffvfyywtlntsdsz\n" +
            "dwmxqudvxqdenrur\n" +
            "asnukgppdemxrzaz\n" +
            "nwqfnumblwvdpphx\n" +
            "kqsmkkspqvxzuket\n" +
            "cpnraovljzqiquaz\n" +
            "qrzgrdlyyzbyykhg\n" +
            "opoahcbiydyhsmqe\n" +
            "hjknnfdauidjeydr\n" +
            "hczdjjlygoezadow\n" +
            "rtflowzqycimllfv\n" +
            "sfsrgrerzlnychhq\n" +
            "bpahuvlblcolpjmj\n" +
            "albgnjkgmcrlaicl\n" +
            "pijyqdhfxpaxzdex\n" +
            "eeymiddvcwkpbpux\n" +
            "rqwkqoabywgggnln\n" +
            "vckbollyhgbgmgwh\n" +
            "ylzlgvnuvpynybkm\n" +
            "hpmbxtpfosbsjixt\n" +
            "ocebeihnhvkhjfqz\n" +
            "tvctyxoujdgwayze\n" +
            "efvhwxtuhapqxjen\n" +
            "rusksgefyidldmpo\n" +
            "nkmtjvddfmhirmzz\n" +
            "whvtsuadwofzmvrt\n" +
            "iiwjqvsdxudhdzzk\n" +
            "gucirgxaxgcassyo\n" +
            "rmhfasfzexeykwmr\n" +
            "hynlxcvsbgosjbis\n" +
            "huregszrcaocueen\n" +
            "pifezpoolrnbdqtv\n" +
            "unatnixzvdbqeyox\n" +
            "xtawlpduxgacchfe\n" +
            "bdvdbflqfphndduf\n" +
            "xtdsnjnmzccfptyt\n" +
            "nkhsdkhqtzqbphhg\n" +
            "aqcubmfkczlaxiyb\n" +
            "moziflxpsfubucmv\n" +
            "srdgnnjtfehiimqx\n" +
            "pwfalehdfyykrohf\n" +
            "sysxssmvewyfjrve\n" +
            "brsemdzosgqvvlxe\n" +
            "bimbjoshuvflkiat\n" +
            "hkgjasmljkpkwwku\n" +
            "sbnmwjvodygobpqc\n" +
            "bbbqycejueruihhd\n" +
            "corawswvlvneipyc\n" +
            "gcyhknmwsczcxedh\n" +
            "kppakbffdhntmcqp\n" +
            "ynulzwkfaemkcefp\n" +
            "pyroowjekeurlbii\n" +
            "iwksighrswdcnmxf\n" +
            "glokrdmugreygnsg\n" +
            "xkmvvumnfzckryop\n" +
            "aesviofpufygschi\n" +
            "csloawlirnegsssq\n" +
            "fkqdqqmlzuxbkzbc\n" +
            "uzlhzcfenxdfjdzp\n" +
            "poaaidrktteusvyf\n" +
            "zrlyfzmjzfvivcfr\n" +
            "qwjulskbniitgqtx\n" +
            "gjeszjksbfsuejki\n" +
            "vczdejdbfixbduaq\n" +
            "knjdrjthitjxluth\n" +
            "jweydeginrnicirl\n" +
            "bottrfgccqhyycsl\n" +
            "eiquffofoadmbuhk\n" +
            "lbqfutmzoksscswf\n" +
            "xfmdvnvfcnzjprba\n" +
            "uvugkjbkhlaoxmyx\n" +
            "wadlgtpczgvcaqqv\n" +
            "inzrszbtossflsxk\n" +
            "dbzbtashaartczrj\n" +
            "qbjiqpccefcfkvod\n" +
            "hluujmokjywotvzy\n" +
            "thwlliksfztcmwzh\n" +
            "arahybspdaqdexrq\n" +
            "nuojrmsgyipdvwyx\n" +
            "hnajdwjwmzattvst\n" +
            "sulcgaxezkprjbgu\n" +
            "rjowuugwdpkjtypw\n" +
            "oeugzwuhnrgiaqga\n" +
            "wvxnyymwftfoswij\n" +
            "pqxklzkjpcqscvde\n" +
            "tuymjzknntekglqj\n" +
            "odteewktugcwlhln\n" +
            "exsptotlfecmgehc\n" +
            "eeswfcijtvzgrqel\n" +
            "vjhrkiwmunuiwqau\n" +
            "zhlixepkeijoemne\n" +
            "pavfsmwesuvebzdd\n" +
            "jzovbklnngfdmyws\n" +
            "nbajyohtzfeoiixz\n" +
            "ciozmhrsjzrwxvhz\n" +
            "gwucrxieqbaqfjuv\n" +
            "uayrxrltnohexawc\n" +
            "flmrbhwsfbcquffm\n" +
            "gjyabmngkitawlxc\n" +
            "rwwtggvaygfbovhg\n" +
            "xquiegaisynictjq\n" +
            "oudzwuhexrwwdbyy\n" +
            "lengxmguyrwhrebb\n" +
            "uklxpglldbgqsjls\n" +
            "dbmvlfeyguydfsxq\n" +
            "zspdwdqcrmtmdtsc\n" +
            "mqfnzwbfqlauvrgc\n" +
            "amcrkzptgacywvhv\n" +
            "ndxmskrwrqysrndf\n" +
            "mwjyhsufeqhwisju\n" +
            "srlrukoaenyevykt\n" +
            "tnpjtpwawrxbikct\n" +
            "geczalxmgxejulcv\n" +
            "tvkcbqdhmuwcxqci\n" +
            "tiovluvwezwwgaox\n" +
            "zrjhtbgajkjqzmfo\n" +
            "vcrywduwsklepirs\n" +
            "lofequdigsszuioy\n" +
            "wxsdzomkjqymlzat\n" +
            "iabaczqtrfbmypuy\n" +
            "ibdlmudbajikcncr\n" +
            "rqcvkzsbwmavdwnv\n" +
            "ypxoyjelhllhbeog\n" +
            "fdnszbkezyjbttbg\n" +
            "uxnhrldastpdjkdz\n" +
            "xfrjbehtxnlyzcka\n" +
            "omjyfhbibqwgcpbv\n" +
            "eguucnoxaoprszmp\n" +
            "xfpypldgcmcllyzz\n" +
            "aypnmgqjxjqceelv\n" +
            "mgzharymejlafvgf\n" +
            "tzowgwsubbaigdok\n" +
            "ilsehjqpcjwmylxc\n" +
            "pfmouwntfhfnmrwk\n" +
            "csgokybgdqwnduwp\n" +
            "eaxwvxvvwbrovypz\n" +
            "nmluqvobbbmdiwwb\n" +
            "lnkminvfjjzqbmio\n" +
            "mjiiqzycqdhfietz\n" +
            "towlrzriicyraevq\n" +
            "obiloewdvbrsfwjo\n" +
            "lmeooaajlthsfltw\n" +
            "ichygipzpykkesrw\n" +
            "gfysloxmqdsfskvt\n" +
            "saqzntehjldvwtsx\n" +
            "pqddoemaufpfcaew\n" +
            "mjrxvbvwcreaybwe\n" +
            "ngfbrwfqnxqosoai\n" +
            "nesyewxreiqvhald\n" +
            "kqhqdlquywotcyfy\n" +
            "liliptyoqujensfi\n" +
            "nsahsaxvaepzneqq\n" +
            "zaickulfjajhctye\n" +
            "gxjzahtgbgbabtht\n" +
            "koxbuopaqhlsyhrp\n" +
            "jhzejdjidqqtjnwe\n" +
            "dekrkdvprfqpcqki\n" +
            "linwlombdqtdeyop\n" +
            "dvckqqbnigdcmwmx\n" +
            "yaxygbjpzkvnnebv\n" +
            "rlzkdkgaagmcpxah\n" +
            "cfzuyxivtknirqvt\n" +
            "obivkajhsjnrxxhn\n" +
            "lmjhayymgpseuynn\n" +
            "bbjyewkwadaipyju\n" +
            "lmzyhwomfypoftuu\n" +
            "gtzhqlgltvatxack\n" +
            "jfflcfaqqkrrltgq\n" +
            "txoummmnzfrlrmcg\n" +
            "ohemsbfuqqpucups\n" +
            "imsfvowcbieotlok\n" +
            "tcnsnccdszxfcyde\n" +
            "qkcdtkwuaquajazz\n" +
            "arcfnhmdjezdbqku\n" +
            "srnocgyqrlcvlhkb\n" +
            "mppbzvfmcdirbyfw\n" +
            "xiuarktilpldwgwd\n" +
            "ypufwmhrvzqmexpc\n" +
            "itpdnsfkwgrdujmj\n" +
            "cmpxnodtsswkyxkr\n" +
            "wayyxtjklfrmvbfp\n" +
            "mfaxphcnjczhbbwy\n" +
            "sjxhgwdnqcofbdra\n" +
            "pnxmujuylqccjvjm\n" +
            "ivamtjbvairwjqwl\n" +
            "deijtmzgpfxrclss\n" +
            "bzkqcaqagsynlaer\n" +
            "tycefobvxcvwaulz\n" +
            "ctbhnywezxkdsswf\n" +
            "urrxxebxrthtjvib\n" +
            "fpfelcigwqwdjucv\n" +
            "ngfcyyqpqulwcphb\n" +
            "rltkzsiipkpzlgpw\n" +
            "qfdsymzwhqqdkykc\n" +
            "balrhhxipoqzmihj\n" +
            "rnwalxgigswxomga\n" +
            "ghqnxeogckshphgr\n" +
            "lyyaentdizaumnla\n" +
            "exriodwfzosbeoib\n" +
            "speswfggibijfejk\n" +
            "yxmxgfhvmshqszrq\n" +
            "hcqhngvahzgawjga\n" +
            "qmhlsrfpesmeksur\n" +
            "eviafjejygakodla\n" +
            "kvcfeiqhynqadbzv\n" +
            "fusvyhowslfzqttg\n" +
            "girqmvwmcvntrwau\n" +
            "yuavizroykfkdekz\n" +
            "jmcwohvmzvowrhxf\n" +
            "kzimlcpavapynfue\n" +
            "wjudcdtrewfabppq\n" +
            "yqpteuxqgbmqfgxh\n" +
            "xdgiszbuhdognniu\n" +
            "jsguxfwhpftlcjoh\n" +
            "whakkvspssgjzxre\n" +
            "ggvnvjurlyhhijgm\n" +
            "krvbhjybnpemeptr\n" +
            "pqedgfojyjybfbzr\n" +
            "jzhcrsgmnkwwtpdo\n" +
            "yyscxoxwofslncmp\n" +
            "gzjhnxytmyntzths\n" +
            "iteigbnqbtpvqumi\n" +
            "zjevfzusnjukqpfw\n" +
            "xippcyhkfuounxqk\n" +
            "mcnhrcfonfdgpkyh\n" +
            "pinkcyuhjkexbmzj\n" +
            "lotxrswlxbxlxufs\n" +
            "fmqajrtoabpckbnu\n" +
            "wfkwsgmcffdgaqxg\n" +
            "qfrsiwnohoyfbidr\n" +
            "czfqbsbmiuyusaqs\n" +
            "ieknnjeecucghpoo\n" +
            "cevdgqnugupvmsge\n" +
            "gjkajcyjnxdrtuvr\n" +
            "udzhrargnujxiclq\n" +
            "zqqrhhmjwermjssg\n" +
            "ggdivtmgoqajydzz\n" +
            "wnpfsgtxowkjiivl\n" +
            "afbhqawjbotxnqpd\n" +
            "xjpkifkhfjeqifdn\n" +
            "oyfggzsstfhvticp\n" +
            "kercaetahymeawxy\n" +
            "khphblhcgmbupmzt\n" +
            "iggoqtqpvaebtiol\n" +
            "ofknifysuasshoya\n" +
            "qxuewroccsbogrbv\n" +
            "apsbnbkiopopytgu\n" +
            "zyahfroovfjlythh\n" +
            "bxhjwfgeuxlviydq\n" +
            "uvbhdtvaypasaswa\n" +
            "qamcjzrmesqgqdiz\n" +
            "hjnjyzrxntiycyel\n" +
            "wkcrwqwniczwdxgq\n" +
            "hibxlvkqakusswkx\n" +
            "mzjyuenepwdgrkty\n" +
            "tvywsoqslfsulses\n" +
            "jqwcwuuisrclircv\n" +
            "xanwaoebfrzhurct\n" +
            "ykriratovsvxxasf\n" +
            "qyebvtqqxbjuuwuo\n" +
            "telrvlwvriylnder\n" +
            "acksrrptgnhkeiaa\n" +
            "yemwfjhiqlzsvdxf\n" +
            "banrornfkcymmkcc\n" +
            "ytbhxvaeiigjpcgm\n" +
            "crepyazgxquposkn\n" +
            "xlqwdrytzwnxzwzv\n" +
            "xtrbfbwopxscftps\n" +
            "kwbytzukgseeyjla\n" +
            "qtfdvavvjogybxjg\n" +
            "ytbmvmrcxwfkgvzw\n" +
            "nbscbdskdeocnfzr\n" +
            "sqquwjbdxsxhcseg\n" +
            "ewqxhigqcgszfsuw\n" +
            "cvkyfcyfmubzwsee\n" +
            "dcoawetekigxgygd\n" +
            "ohgqnqhfimyuqhvi\n" +
            "otisopzzpvnhctte\n" +
            "bauieohjejamzien\n" +
            "ewnnopzkujbvhwce\n" +
            "aeyqlskpaehagdiv\n" +
            "pncudvivwnnqspxy\n" +
            "ytugesilgveokxcg\n" +
            "zoidxeelqdjesxpr\n" +
            "ducjccsuaygfchzj\n" +
            "smhgllqqqcjfubfc\n" +
            "nlbyyywergronmir\n" +
            "prdawpbjhrzsbsvj\n" +
            "nmgzhnjhlpcplmui\n" +
            "eflaogtjghdjmxxz\n" +
            "qolvpngucbkprrdc\n" +
            "ixywxcienveltgho\n" +
            "mwnpqtocagenkxut\n" +
            "iskrfbwxonkguywx\n" +
            "ouhtbvcaczqzmpua\n" +
            "srewprgddfgmdbao\n" +
            "dyufrltacelchlvu\n" +
            "czmzcbrkecixuwzz\n" +
            "dtbeojcztzauofuk\n" +
            "prrgoehpqhngfgmw\n" +
            "baolzvfrrevxsyke\n" +
            "zqadgxshwiarkzwh\n" +
            "vsackherluvurqqj\n" +
            "surbpxdulvcvgjbd\n" +
            "wqxytarcxzgxhvtx\n" +
            "vbcubqvejcfsgrac\n" +
            "zqnjfeapshjowzja\n" +
            "hekvbhtainkvbynx\n" +
            "knnugxoktxpvoxnh\n" +
            "knoaalcefpgtvlwm\n" +
            "qoakaunowmsuvkus\n" +
            "ypkvlzcduzlezqcb\n" +
            "ujhcagawtyepyogh\n" +
            "wsilcrxncnffaxjf\n" +
            "gbbycjuscquaycrk\n" +
            "aduojapeaqwivnly\n" +
            "ceafyxrakviagcjy\n" +
            "nntajnghicgnrlst\n" +
            "vdodpeherjmmvbje\n" +
            "wyyhrnegblwvdobn\n" +
            "xlfurpghkpbzhhif\n" +
            "xyppnjiljvirmqjo\n" +
            "kglzqahipnddanpi\n" +
            "omjateouxikwxowr\n" +
            "ocifnoopfglmndcx\n" +
            "emudcukfbadyijev\n" +
            "ooktviixetfddfmh\n" +
            "wtvrhloyjewdeycg\n" +
            "cgjncqykgutfjhvb\n" +
            "nkwvpswppeffmwad\n" +
            "hqbcmfhzkxmnrivg\n" +
            "mdskbvzguxvieilr\n" +
            "anjcvqpavhdloaqh\n" +
            "erksespdevjylenq\n" +
            "fadxwbmisazyegup\n" +
            "iyuiffjmcaahowhj\n" +
            "ygkdezmynmltodbv\n" +
            "fytneukxqkjattvh\n" +
            "woerxfadbfrvdcnz\n" +
            "iwsljvkyfastccoa\n" +
            "movylhjranlorofe\n" +
            "drdmicdaiwukemep\n" +
            "knfgtsmuhfcvvshg\n" +
            "ibstpbevqmdlhajn\n" +
            "tstwsswswrxlzrqs\n" +
            "estyydmzothggudf\n" +
            "jezogwvymvikszwa\n" +
            "izmqcwdyggibliet\n" +
            "nzpxbegurwnwrnca\n" +
            "kzkojelnvkwfublh\n" +
            "xqcssgozuxfqtiwi\n" +
            "tcdoigumjrgvczfv\n" +
            "ikcjyubjmylkwlwq\n" +
            "kqfivwystpqzvhan\n" +
            "bzukgvyoqewniivj\n" +
            "iduapzclhhyfladn\n" +
            "fbpyzxdfmkrtfaeg\n" +
            "yzsmlbnftftgwadz";

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
        solver = new Day05();

    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void Problem1() throws Exception {

        Assertions.assertEquals(255, solver.solve1(myInput));
    }

    @Test
    public void Problem2() throws Exception {

        Assertions.assertEquals(55, solver.solve2(myInput));
    }

    @Test
    public void vowelCount1_a() throws Exception {
        Assertions.assertEquals(1, solver.vowelCount("a"));
    }

    @Test
    public void vowelCount2_ae() throws Exception {
        Assertions.assertEquals(2, solver.vowelCount("ae"));
    }

    @Test
    public void vowelCount0_xxxx() throws Exception {
        Assertions.assertEquals(0, solver.vowelCount("xxxx"));
    }

    @Test
    public void Example_1_1_vowelCount() throws Exception {
        Assertions.assertEquals(3, solver.vowelCount("ugknbfddgicrmopn"));
    }

    @Test
    public void Example_1_1() throws Exception {

        Assertions.assertTrue(solver.isNice1("ugknbfddgicrmopn"));
    }

    @Test
    public void Example_1_2_vowels() throws Exception {
        Assertions.assertEquals(3, solver.vowelCount("aaa"));
    }

    @Test
    public void Example_1_2_doubles() throws Exception {
        Assertions.assertTrue(solver.hasDoubleLetter("aaa"));
    }

    @Test
    public void Example_1_2() throws Exception {

        Assertions.assertTrue(solver.isNice1("aaa"));
    }

    @Test
    public void Example_1_3() throws Exception {

        Assertions.assertFalse(solver.isNice1("jchzalrnumimnmhp"));
    }

    @Test
    public void Example_1_3_doubles() throws Exception {
        Assertions.assertFalse(solver.hasDoubleLetter("jchzalrnumimnmhp"));
    }

    @Test
    public void Example_1_4() throws Exception {

        Assertions.assertFalse(solver.isNice1("haegwjzuvuyypxyu"));
    }

    @Test
    public void Example_1_5() throws Exception {

        Assertions.assertFalse(solver.isNice1("dvszwmarrgswjxmb"));
    }

    @Test
    public void Example_2_1() throws Exception {
        Assertions.assertTrue(solver.hasRepeat("abcdefg"));
    }
}
