package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC451_SortCharactersByFrequency.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC451_SortCharactersByFrequencyTest {

    public static void main(String[] args) {
        String[] strings = {
                "tree",
                "cccaaa",
                "Aabb",
                "qcbkrbolomdwttlhqbldbuscinrsjrvmhjltvplkilimtfpkllobenptthmxfpfdiqrqjfbowklsnqvgfqaitsavhgraicmnvfklodarkcdikfocgxkrotwdubpuadbmerhlsrxdslrnamkwokedviqksjhtpsvpplxioxwsivnjrfiknxvwjqxmroawtxpxuntldepqlhwmmaahdxosiecqjqdmorqdvfklhkhukcvoqmdeajoqmndglphvpchtbmnadpjhhxrixdbcepwpdbxhfkfcgqvqqsmdqelijlksqtrhqpfxpqakadvrsmcrkpwtvanpibscdnufkcurgegxvigvvovwhdmabvqnmqxsqacueiddsdqxksrtgvhxhnftgrmanhrjhokcejbqchxjrbffftpncgsllnqktxbqanmbufonowkfamdckoghagdaqjudgaxvtoritlmmoasejeclgxdwbnxlnnscokkdirrqamiujphfdclghwpindgkjqxpmndxxolanjngrkaageffgtsxnpraxuwcgijtanqarhrjwawwclratfldpcasuhvufmngunxjmjunwcqopwxvpvkdvuccjsemcrwqbpbboghskihqfpogitihffqpwnusupfkjlvlxvkrcscmeexlqxfpbfbrlhnxkwjdkbmuhpejoxctugbknratxmwbjsgsovdlwjggougcxjounvvvbjsujjxwgeidhollucsifehvtopphjlelglswflqeosdmhicdvbkcoqjehnvljrnljclgacajifaxrdanskfwuaoathnxossakxjjsgnxkrvhddnrrgqceanjmwquqmkebltpkuxulnhmxbsxcedmpafoarmtpqggggcikpxkfraglfghvvhwnxgwbbtllvnwihuuifmiooxfiwkjjblhvnjlfnutemxeqhmdvwgwpuubgunfhphorlfuvoqvremqonxfjdgepkalvihlhhufxbcbaeoadwfdccpculskajkrfsqmjtbdqhicqgoucsblmgttnifqaidufrrgmagqedaptfjaopabtitwvhmwqqjvwobkkjdmkijqkaogpnlwbaavmlreqrocqjarbmjxemewnannuvrauqrwkrdcikkftrxrcrpjiqhheeofgpcrvfgthusiatdupgfenbgshteeofcpokppdcidlcxhhgdbdrcqjmncjnlonsirrphmqeonntbvhislrcxhirurgildxmrmkgcpsoatgiamgmwspidqqbdigkeenttiigjpkgomojfcfibfwugdsltvidwkowiwkhtwimjafvpjdmkwvvapwqlrnereuoiebcqtucrpkfoqkjcuoekgmxdffmwbvkjmnprgwfujpadwahppxaehljuxaenttlnmovmpvxmospfnonearsesvffbweebuaegtvdwsiagerumedgnmkmiifwsgtflrkmrogwtgiajvhqlktxhiptpfoacjsxjrbxenbexgvfaejccpsoonkjqtskaxqllgemrbonivsgbtojbvdltsshdubugqwaboempkmrpcflfqhgqkmxmiimbwcgdemwlkqoohdrfehvfedqphfjlqlaqtwrxkrvjsrkokmequpdhpdhwmxrwxmecbfekmfolwwihrhkckgvnjgtwicipatpfqoiuisqsvijjfdebglewrfvnnnvuspjtcjdghvlebwmnorjhhppbjpmujjixmitcoqqwibatijsberrdgbwqxgaufvsxxquutamnnlontbrowsvmmskcuhklbckutmeisurdegvurvlfomlehcchqmbtvxawihmwtjwrxiowmoiusaokpiopcnvdanuvvgdgokdvmrqvklgfdgtwgeocujpseuxrlujqsfbjdslqfvpoifmisqdamrwcptasdxouikxeotixdddrlgaavjmblvkkcdqatplkbsnfdlokfoavsiaofksnbudcetftdgxkkvdgedfisoarxukltrdvvgckpejufrtmoscohkfdeckhqcinoobhjugcbnurpdvjuckfvjhdrlxofjkfqkumtoakepnldjhplmblnaswsqgoajhuxfsnudpcokethwrqmrjqjgxvpkphpmpiuoniueddpvbxmibspjrehtmqqacbepktxgfxtautjqmrbxrpudkxaalhutievnrlaeabiqdtcfwiqmjvlxsjufedvkaillssgbivnupemjptxppglglkdrnkrotwfmawlevnatamvpnuppnbgqnlefigrxpmfoibngnicfxvofscqvsvsuwcjrnvueglrrecfhsgtudvwdvvkaxeqtrqiusjmwqmkwdjdodxcnewxshvmjlnhmtwcorbxudfqvwggujlqltxpkxsiagabanthqkmhxjitvujiickwmxhpsfmumanexiowcdekwsulpnkplbmsqiapsrlrvsmbqmbjlgirsuihcbjumdjfiwrhemixetgauhtwukattbwihbwpmckgmckonnrnberjkdlomaukiafgoukicfvhlldgiupvtlomdhtbeweeccfjotlwpudwfkuvtclvdsgigukhmhicawgbpekkdafmuwnewwdwajxgejahdibmtmqvtriufajrnhxlsqbadhsoegnsbdvssulwxktmwejvdnirpbdkutiqxlbbppvtghpmgfnknfmhejjamqtwcaqmnrfbnucboeexoufwlcbqacdgcfikolrrfhpfkdkkdmshhwkpadcjiqeuajbxpovqioqmhlwpvvsusuwodigaumgchtanfbtbfejvtuxplbsnofiteknnlnxqoteekktentqbhpueoimdnjaoeaxswtbfgbflutnrxlwillmenagwejwpltmvehtdhgluttriecmcoqbrjlcwflcfikmawqvqqbwnalhimkjpjhcrjjwsakebmnxbtggvkdpplbxcwlegdwpvgqmenteloufaejqjmdeslxrgslxanaieqslccqkthaxhrscoxjonjnnukebvosviwgtvkahjhidvjiucsvnkekuddvcfxowprfmndtbefusjvugxgakxfoevaxsahdlkqgorocjorfvmunrllrtvtrwixrbwxjebmrrlkeivessgpdtgiikehmtfqtxghrbueovrhbuswtlpfwfcfowliobmenurwklkrosuhcpmobhwpppfuswuphkulqihnfankaqeqwafflvevvkrsuefeinhedtidaktqfhbknglljhkgaeusexpghjdxowdjvxnlmaswqdxxmmfcbhhjdpcoxibgkxsoejkkvbiewgjrtmashsbsaeodvrjxoatdtwmwaledxxjcwpcwkmutmodglelkshhaeirwgpmllopcnfkftxgeovihajoipoweowltweqoltcargrijsaxgbgvvqmqmdxicqaeqjsjgwdfjkxxmfkbusnirjdlbaethorsmqapnpdqgbmbupevbivbuemrpmdwfhfflqtwowxkguaoksnqmlviokxrvgfqnvgmvqlgmecdlrspvwxvwmxuqbtelqssnikiikiaupdcvjemgjasfrbgrcjrsbbdpgcaofseaarikveemmbpdumgbgsrabeelaovwrqjhqfmedtahhkvadilrduuaabfiwgwbwuijfxodnaphskmcqnnadqrhgrfwqrmvvmapbhafkvkfwtttcsnouvqxumnnhboeejsilmqebabirtlcqatmafsxqcmgjmnoecfukioauslinldimxwbwghhdddaalrsfbcdqjdhkdjoidmunhxnoboagobdcnrqqmjouqxlddcjmdvwtqniqoirhuxabegilubmoejdxswrhcpxgcrllfvsqnvougxlijkgwxjawhxxlcsfwekvrnuexbsfcffqnloluqbqaddrhjncdhrhshnwoagfnhxhmcsdiggwngsklijwnloqumbidrdpengimnbgssdhnqfhxgfauqaaqsatingcxwsuevbncuovjbektncirwipgbrwumshouslgckhalphhagshlpgsmfwgtfjhovvjnplrevnfrhnihdidcfdbdimroderdhuakqgvtsfxeoavefkpimwudabvtuakkjeutglcgqrafdxeibddntxvewgmkpmsftgtqalqwqjouhkxcsqptkpcokkmtfrrcurgixmxdjltrrcvmgdmqcnvqtnhggopkfogfsbqfujvtkgnefdiodbnljimsrtuendrnsxreitwmbordqinlvejqgkcjpqjsfkibpqdxopvshcqrpdriwmtmhldjhoucuteqidxagpsgelkwrtomjmckhuwtcexntmumgqtvhsfqxaxsxqlrujordulohkilshhlaqbpkjohrkxmalhnhvpigdkexbreqtxhpcxogtvnrqkfvcmrmpviwjldsaiivbtocgpbuasiisqfvijnqpibtxwmhhhosqdbcnxkdqvrfijujsojfgjlhutpphnapqxxpfbxuugqblwcjklelloghicmrgsuerxcarejgtvftkvouhaasxabweedwxvsxelqwoqicfthmvijlkvlbqinbpptfximlitsqgfdalwxmnfufjcoaaeslsnnpakjwwpapqlepmqncjwmdoprqxwakterdrlijfxkcvkrqihrpjjuerflrdmpgmwxsluctvuhslstsivdsgqlbbcgsoaoafjpuedheomjoftcwtadupkqcgxauqjpqmpqqwrhojbgxagolrcaemgmgafcgxpivdxlxbgbgnbpnojgklsltwopnacubvcsqjaiimdphkglhgvltaimrmjravawmrruqhupmhgxxromoqdwvietvopsphwxauwqweciccbsgjlabvbmjlgaqmarjwtjfeimsicdtwkavsejburqwkosjpmphtbcsuijllehhkdimurnnncrfemsbglmroplajuprgqvngducqsfgjlgncaipkwqwffdonnwnixnnkjsavwamhoaxlkemjldoctmvhlgxcppixhdvmxiopsxsxswqfdmcujemxxwwsjcofmxcufdvrhlpwjncwhmkmhvuwphdkwipsioxvgkagvugbftkcntvavnftnjnkexrilptpdfanmjophwjdhjmkdegohevifihgvdglmumhueqaiphblggssuhahilwplxuoccqjwvtfldnxvtkdcexitriluommhcdgeuwtvcjxpandcoioeobplegfkpicwhkobgwqhmbspwaguikdvdincxtmafutwwkmrixsvlmpvgwxeibefevujlgipqaoqbjrtkrxwwrmhiagsgequihspapjwkkdefrgalfruoitwtokotlxriwrgnwphjeccnkjqlsxvckckagfapxrolkqecmsivvljpsmldialtwddgkwhrwojcewkiistxggtddnbtaguameqobgfckglemnixtpghvlgsngbkbajknhtpltardcmsieoodrbmecdmwoujtgjbqlkkbgqxiaeestdgkjwpllsiafkhwqgmvaggkhxmrrcrjsjpafdhrpspcldftowmuopexxexwghrojgqmgcfounqfxhdjisawmmuoewaaflgpatbwvbasdruatnabxcjsexvjxgbgqgnwiqtwairgfpttxxmbjggjwgiijepiviblhuwujjprqxugrlqdxvqcqcmjrivxoqifwbbbhtmtwqxkksmpcrgnddkoorikkaseovvfbfnnwmvokmpeiijshrchcbtbioiqnrjorqmfirwlrqksslrsvddsmgeuclscvnwgomrglqbpqxvrrbnmdlfbubtupxhamjleirtvbrxuvkpreuoakxrtrkkixraveebjhgdebeqkkhqlsctxlahbvqgbctuwuiqetnjclalpvobxfvfimnwshfroidevmdhnuumihoqnabctettlhapoxxthrkhbdwxesmmvvxqlcgkbpfojtpbngpmuoqotdqxsousrvrlckxsaokgjqunacvlonurcllqggwwuamqbskjbbmsdnndgeaqepqhwtvralqhpusiqbaqdarkxecchmcuwncjhlatbgegjsrcahigwlkawmnseljpvvlogmsoqvqdcdsxpeuekcprxnfuuxoaqjdpsutjvsnndffgqqscqfaqlpbapsraphcluufertcetcciidtpxnmtjdsvokkodjhlkmoadkbrsrrvrnhuxqvcjximarqdtoepwfqftoierbjekhoirarglucvfgnoxfhoafrckhimxemwdxhmutrxacshgjxaqqbawgsqhejsebasvgmhilumxcwckrhrvgsocxkpcxdvaqwjhvtkggegichhjivaoprquptwlpnwujvkjsffnwpeuevotnavddiwsilfdmrupehguhsxfshpkwqwbaksnsvwojlfjwnqcbkvxcrbpscgcsiasjrmlejdpclwowcsuihokvmscgrcnpmlprwwgselgklprsqbvjgbopbdgfddcmnahwrgucvgktdbkdoofepisartlbcibttpcrkmpfwftmsercoqnrkqwimtssurtloxikqbpuvibgbwxvgambgekhkssocqwegacsevcnlonpqslnhvccukxvkjmoecnokthhxpkcqagapovtjqaomcecfqosksnjlqpdwapbmgnjgloolrntgvsoewcklwifkgtmexhmwwalmavvxxbtclirneahbgvtmwcuifmcqtbesokktsvnptodijoxclebeiucbjvsadqoqmfuamaioouuhooexvoiblcvaelohxdpodplwsswatdvicquitsaspchfofnewmjecxhfhmocdcemgsjewicqvppaglxrjdkjsoimqmipnbltsgsfnjudvonrfgeepgmhddwfqymwkbanfuwbjmalorjxkuexbxoeuwrwnusobbfcxspbjbvpbhltoxpignqbopbiqdkaebbbkkevorsbvrdnqpwapjkvqxotajeuqsdtdtnealrhtnsnblhoeceklfaongrshtnbnwcawhjsdvgdadtmuqwwwcidjtxjjuwagjthiwksmbaopxdaxtqtcuuibhhdnvotwhakaguggxjatanlxukpofooatkwuhnjwvsrdshilkphgvlvccecunevuvgtoblrwnpuehtwiheeigdoioworsqnvpnssmamnwasjhabixwwquhfkobrpwrvujfcqxmsmqvvkbojadphxwglxmlvoiogbbinkkqtcmxlqnooltwfnmhbqiwifjjadjfbffcwqrmvteohxnckjgenviilvqjdtamhertnfxgtkfhoedndtvmhvodngfgxapehunegchuuoicbdmgtmaxbrkwqxraetnxrijlkpankwgvrujfjmivjqsacashbmcmewgkbtkltdgcvgrsekegjtilessdpcotcolqsoofaeixpcmfwhmshkdogfreofsfrriuxkcljkvgnhkgfsastdmraigkwwnqcxgagmbnvfeobgugbejuxbsucujwovafnxdlihaloenpbxrtuforrkvxljkoqrjebccffbjfsprrnbrwvmxslhfcunsucdkoqpiwusltciwuhffadrfvlxdnnlawfclrihxwxtovwmpqncexxopmcdoaojeojxcxccwnmutdogbfjqxvjinnxkpmxipcwkbogpotumjormotrrmqbsicufmphhielsqqtwviplrmrgncglvkobhkhupshxhlbanllqvmvdjhunosxwrkkisvbwqghpeordcjmvoigsdndjcegtjhlvccklvbxiqpilwrpepsbixiwjagrbmdcavtkfanpjdnjkcluoitxwdougbkjkcvhcgpbjjjgdtatwvhlsrmaljbxhlwwtenbtcwwcougokifppftjtlerqivnimaoatkstikvjavrhniobvvdekdvjdxhxkhdjxiaiofvjemnsxmtjxshhambdrfgbckcejunbwhqpasjuhrnjtigrnanwegkftcblsgxhjqocejoetpvbjxpuahjdtekdfxlnqfjbhxjkahltevkacjlhdblipnoupjocmljabgwpegjxdmfwuejtvwgxwsixlqdlpgisflxsaepkgmftassxwvaqrtnuadjxppvbfhesergehnlixbvdgircqaqtxliwgginhjvqbpwtuxweqrthvntvdaxvgisrktlufdbknmobpjahsemeunlbdvkrosvxvnuigticcsxvpfwshaxjbpmhonkpxbbqfgtikcdawxiamrkdwhfxnvtggbpajvhfeervaqcklmcboomnwpnmqvtobjalnfxnjaggsvesxivamllfbrakdbcqreojrcaiusbdxjsxmnqoacqnwunrmpatvuiihukovrsuxtdcbrtjbrlunsvxfhohmhhcftpimhlkseakvnheqbdtobigvdmmqwkhngmnjcrmjuahkrumlkarjknwlbrlibkfoxewelxdslmspfrldedoxnefjdolmhhoievjvkdgojukebxiqpukokxvwpsfmkarkgpivxvffvpxrmfttcswhrtfkwgaqinpgvtdkroaabwbghufkggbkblgfxkeisihtirrfbwinlartcmfxditqlfhpefbnqwrrbakhaumweggbnmdijxvxhjaalhqfcsnqgrwotjmjlpioqnapadojnabivrirpkmqadgunmjasuilsgdspfwfvclhklkbjofcxhjivwrkhufjmaudivgcwovncmmwghreluxjcwxpdqaowsurrcncbmxtufqopvgptlqrnfqwgixuivsulftexgkxcwwlupwuamnxotwjidurkagmfviifsfscommmwrjloflvhipbsoxdmirbdfowajvvfuabbnacbjnsspqamwvfbjlnwrojjmxduvjjbuhfpivetsmocddowqscxfifeqhlliovvoqwnktutretuvapugwqwqulsehhbuhnojklghxsbuopjvwpsjphckcltjwfprmauhenaqjgomtkrcuijdoxmdsfowlwuhfiwpaelekibatdfucaimjxdunamlikbpkteknaamihtqpdfdabqsriiurgujebwqdkaptbxguvevflaaxrihxlsthfxoxsstinxokgxmhqtoxqpkvartrfkkignnjwnprumxkrrwhrbdlvjbdqtebbaicjntcoqepwfldqesgpfvtbpobpfmwodfpgpcthlkqfcjferkluadwdrqapatxtlkomursevcoxmkjuhvvgrfmegpowlxgrkooeuqamhlxntmvcpmohjmuegmfnxccivrjgoiwgrffhojcurwffaoqdlollmdtqpmgklikdbjgegrbdulsqnohqcnkcjlrifnnqdqnlcgmocsaxjuvcjjjnosbawbujchghnbaokewdtgrihhwrlboqmeaouvmeepjbrscmsdeuqndvpxnpmfpkhdhedpjhmhwmidkurufrcnfiirkklnclnavkcqekrovjkvspqgtbbirxtxncbsitojeaspdpdmpqoprvocngenodhaxjgdsrejdvkexumskqvrxwepuwtfmufeggrbogenlklijljphdwtusjfgciplcfutqckfkihkhncpcvmxxsgaageucattewxhikaanqwjmhcdsgxqnijlstnwgojmdbfawrlwhmsibsrlcmkefjffgxhevasghnpakgrgqteannoruafrgvbwvdkpjovjalmvdcechftprajmoswjcdvghohfqbdoocubtfdrnlhpnvtmrrplpujwljnidjslqtitaohdsfbgjslivoxpohoeddewcvejaopdtfxhwkqwvxjskaxvpfdknnfjegrzukrreldpqdmnqnfrhigmcvagsxxitlhbvqgvkatkkxgnemqnwweooiwkricknnadlhpphlqrkpffplrwfjrkvweeejhjtlevnqdhrfbsbkrfccbnfbwbngcwsrfmvobbvkdvbnxoxrdnvtwqwhkrhbjxkrudcwrwjwgjpmjndejnhedahtotcwqgfquoukdeslelcsxqpkovrnnokuapawhvdxofrkatqcvuuojnrupvepwandkwxqwdtnbqcqptsdssdaifkjwnwrfxjpewbngqpdoipbiuknspikdjsscfpekuwjmjmuwevrlliitoobnbljkabgtvbqwgtbefigpiwocsetbbxoeceagrowswdequkguuptxcctdvnkbnvvgidnnotjwgubqijbknhcblrxvfrwmsivdfpasgwqpxnoobrraxcecddtiarpirxhdqrscridwhwudpkgfuwielxwuanuialdpjjchojjsqwdocecctmxgjwjjuugjauahahkipaldapsqkgtwutaahaeitaevckxrncpglpacjprqhkbbpnmldnorphhlvvpximdilmbwcpbwjovueqtwpehcxkolinjqbdwwfqwhlpskqthvtvmjrxjnlrkfvjueaiaqclgguhdfejgwmuhulerrtltsdcjundahsujbfxnovxdppfvaemcphsickqhpqmwcovqdggpomhvpnqgvmhcghmrtrdaoskljmmtjxvstpxfgmesbdvjgdspxstrpbopffsrnieopiqcewchobviptucvmpmuxbrncxtwrlckvcfkbkqdwbhcpckghjbnkqcbcliedkgkiuvxpmlakpnoitoquppamgbcufjiuamjaimdoqjgfiltujgvrrhhlkphkhgbvorommxxanbeptasfstvpjbkblladpgpheakgrqbmutdjcfkbhvhgoupvsgwhwjtikxefppebgbrrljdkattphqqxpqhwmbukqomjolfjiqqrhfgoefranwuxkagxadkuvgksffwtntahwjspnnklawevdwqvdkwvdppagfgpuqhviexejjvwihxrbuhfwexhaaclpswvepxjvowvjjktekvlnqsahjnjfjutjeefgbqfmbobfgrbgwgdxcropsalcueqmmtakgiqxkhkeathemtjxtfxfhbngwktpkqmqfrsmmjpagqhhutvfsnmtpppscocmffsppssdfvbpqoihfwqqacthclbxgrprgbdrlmsgncosxpcthnakvcossmdtssqhvmfmkgbenrxbdsvntpgbihdeucfgpbxgrhbjmahmviumeiblrmtosrevdfqkvxcokjiiacfpubfsqhggqvwikwxevgcgtltojkjjonbnsedfkknwbjojbqodsevbkfjxwttlhiuwbhmtawuduafxowaatpxerntbidqptmorhecndfmuqlkusrveaacpbmluishnbhaamltdkwgdnjfgfifgqwmbssaqfiivktqbjkrufrioesnfotiqejxmtfknqglxgiqffllkoxegngutgcgadsswmhbkqdakeewuswildxicpwjwmopaoieaghnioaxaujeffrkauboelrnajodwelxkbvpxcmqppobkioarcgvkiiwhudckodsuusvplhlqfeeblmkveemwxcfeolegubnwiniqsjidnkxtfeqomgngapkworsbnmqxuparwtapqirqhuscpjhkkhwpossksftarwoliubonhcirpqkppkenthfdiwcctwbxeiohemwngcccsdgehwtkswrhkebwwkkfjisumkixfjxcxbogklwremlcawpnwvddlmxxljemepplntrtgrgbsxtlsslieattuwmhjlrueukcejjgwiltljqdbcggxedclfsuhxrgmbisfuefxrmxpruknvrrhpddjbciumslmurqhktrlcdmhpvpmlrwvttevcbqaevsfouhkvwbreokjcmcqmbxigdnxpkxmwkmgisnpuevrqosimrmqiqeakspqcedwkrapidkvwpxueteredfnhfmowccwtwujirpjixpmvvvjcvhgceegrrirkjvmirlcaurlowevqxxqruewgsstomqrvqipkfidsanfupawpvgsaxkcrwwegglwrhnbbcklogdqblekcwbwjxsirqjsjxjjffrjfircffntnshojmceluuspxtmqodbjdphxohbvpqoaesuenoewgxitnlcjvbpfcfenfjhpshkrbftlkpxcvtioqbnocskkitxbvcfuqqfkqplgtvmpqkmwrpefwxcwnsqbgirsxtbddavfiamnajmnikxaahpclkipatnthbgcijirqwouvtwbvfpvkdkgbcojsmqvssdiikfqvckuhnmmintgsdkdwtsroddkpfqfkckensanocwvqvtkjwpptufokxvjftfbacrtbhrqkqcegtijpvcuqgwixbwsfldfikcxjaudcxsqsxidepkauanpuqpfpgbpubtoenripqvlusoaiuhfjlcldvxkctxbcposmqrfbtumdepasokknpwmsaobilgbsvsshxduihwlrevtltsxrtackausxnnjglqgokxltftaulpjttxmnqrvtncvitmimaxvbsgmuutefrvksprijfhfnqxslsenwfxjpohojfpfemagapbnvdutirmraemkcbjbcacrlqgurphomswsarqvtxxcpbmwrfdgifxfsuardilqiajilqjuhlkohimbkrhgkxpsnsofdacgktbvoijbemnljsnthufcqwjiorhosggwlawcjaqsktwdvpougwecskohtblowtoccsapeiebrqhetgimiamghbfxnutlxglirxafgspniciqdpctfkfxrggimiwppausopvkidjvjkpommecnlqtwprkanujuqrhklxpswitspwvqkwhhmmuxvxgquwipxtxvlhverggmkmpvejlvejimphswelgqnjshoudwesgwckttxmhnmirmfbxaxtspjtainoihqnlsqhrmwxramigjbogxcxmmtrrpxoobnwvoldrphltolbgrrnwkpvmovunffceccfeemodlchlgcldfnwglwhkwedukovklxkictbpbildkixungsiahnomdpgwdmquoocihdvjbakiwujatqllbgrqqwlrmboemqqarvgtumabdtcawiosusbslcucqteumatiagawccfnqdhdmkdvrrpbnlhcitkvmxesnwmmcpjemmakxhroiempoqgslpavmejmpvddvfmnqowfpoiticwsnrppccgefhuopedmttgrmchudiaoklxltgmumjumxrtsekwplchjphegmucfnafkpptqsglerbqpqhsefihtkonncsubcakoknoseirtupcuqlrckxgxuvlhmchjqlfqdiudbxakxejswpckspmpwwmvsnlpisvbdovtbugrdxmbktfeupkrprcpgcbrklupsrrcvofxxqfrdnbqrhgwameenjpafjrkhqaafftwexdbkxagqhswjrroslxujbumlusuakceknwdpirfcqubjpdlshpfqvndvdxhxtrsqrovbjmxhiopbhruinjtxmmjwaxrsdaixumaiikswkhxiidjsgmnrxrevikcqhhgoegdfqrpilocpsbbarheuefntnqcbjouwufaigswuvfjvfdgloeiqfgtpgsqwavbojsfqufothljdsrgtfkbwcvicdwvxfmopnleorlrekavailkhhrhwcdsufgrdwdtjhrlkvsfifeefarkqtjrhvwsulqetwcqtxfllrudoihfsrdonckqsdiadnoggscfnoolbuxdpljrolsvxtmewfxuquwxvurbbddfngfmlxsikgubwoinujnvupswatifewwhpimajldkfldarlellcjnhorewpijbxocgrgnsqsoijntqlbvunssqjlribxvnxlotrcmfeawsiucnvafxusvxjannaxjlffdnqantrwaubwufrpjdgawngixvupurcmqfpqqtxcnolvltqqsqeeucwtjknwixfapkfsegegfhwinujbqqfwrntjjsuwdhgjwvtgdecjphcxltuukqbothmcivjwgwnpgwamlercnqabnoshkdiulhrgwecojxdcpmumngxlfxxisnseoxlirgtodpbwdhpcaahgqmgtihilebecxejdmmrawnvowrcqtrkdwtfcgwccrcrjvlltgatnawhgilksoaejfwfiwmnokxpbhexrvcsobufwsvbcsmvrhtffksjfpjjcxwhoctvrbujguqxwhogescnbiqhaapmmtklifdmqijthvesauwwboefurvgpukshuprjobqknbsxpqmhddnxvjowncglncclcotqnoqokuwqinmccneqwqpxmgqcrgurvwaurcmgfdxajsddsgcdqbaqgstwrojpuqjhlmvjhoobcaabtthpewspkfxvnuqgqmfilmkhqukbkglmvpmocnmvjqfbmnjxsbehbtlqpgdclnmepaxxroxtdtmbimvipihevjamgdjdlfejlwtctkjxaveepwtdsiuhwfkllmfltncdxsnxgqudiwgmcwdpkkgifaivpixutopseepwljxwshbqrkodovspsjdskivndpcwctqacftqhqfitclbhssmfrrllurwtrdqahatllhqpbsucxkififioiugmlkxstcwikiioutisqjmmbeaiatbmvemlorqboakibxpchihqijqshhbacvqbbpwjmmracesbporqfufqplqucolmncwdtpcwwfdpowqlkteigksmovvsbgogkkbddesctmmwcpkwkikcbpgcmjfdfbkmqwtidufueqfmpgkjiusownstrhjjwgphqflubjkgbrhcvdxveadtgdmwpocktvnwrpafnddorhqaewacnthdbbvfegohuhftmneeiqxfmlcwkqxaennmginwiphqtdnmrggjckwldmdesbtpapnpgpftureenkxchswusiqxocnbkpuhcixlbwlshvunnkjfhbmnitvlmnxhkmspsalswwrtktjranfnquidojfvgwqmehvahxjsvgoifbsrjsbblcshjvawmmcbfaocbwbexojhhjpnocpdxukbueowfqeopilvrulaepesjsamxeojvaqrfiqmrroscwfapsxwtqopkvvqfqgmejnhmimsrhaxwlefcgfwnbxxlbghaxhmfuhccmlwvssdcfjkdkohbcxbuwlspiqjadhuxnorulnpwosarwqcamwpmmurtdlkmnwlksttxrxddwrxvqvxbwepdermtqiqskkiulmmgfrgjtfppcdwvbrklfdcqqvljlnlmjilpvtshhfxguexmmnajhankstdkpoltlwkvlgfgjtiluprnhijqdklqwcamgerqjipgpqavcolfudnbsdmnihvcntrqirgedftdxltfjofflstxgmddoblcwuqoouahcnvdvnnfolbcsdticmmaowensotvxfpqnapxrqiosegfagvdweiuxakgpstweunqnwxgjdcatudnnlbjlthijgdcxwiaubagjxpbxgesmajljsosaaaeviimkmjepecdblfhkrovcjaxvtfnfvfpcfjswlxrvvjwfccjdlqiphqaqwoldjesaxvuntlipmwawnfhbwsmccjxlmrljlwexnotgttqejqqlsaiublitlklfdvgxfdgaxcpkvpdnfbpmkrmuvendamfguudvgdacgspqajoigpnsgbncanlrthugaulmgfroiomqeqdhotbmmibnlorfctbonontfkrcowncrlsctvusooawwpxahqlffscltlriajtpadkxpnfntkddcpwrafetwxcsjvbaxbowpamiasfucvrgfpgahmracxutvlaarmvqpjqfawdpfadhqphwtdefairlimxsalidiqveohixtbruuhxrmdvcqlaelpoocwjjdtdxsweteicpipbusdlnbacfufmcbuncwdtnetgtixhitwtufvhanxogfobamhhedafxmfhhxupnpgnlvxrsdxfiecgicnerqkamkwoajjtadvaaksamlkpctjdqnphrhbvmgemvwmsaxmeeuommggtmakpsmvgkpedpiqihovvwdtiftdofcebwnwlnxorghmloqclmkourxrvvqbguqlkbbvocwermrbvqgsfwawwblilerhllifwfexjxjngvelqflpfnjumopgbixogjdqfqwutpqcxiasuwnstxwrnjlmpddghghofuhtwhldfnvnskodiovvsbhsgntpnlgvrixgpjdahmdnsjmsmsqhchdhoerjixgfpnodqeoioosddmbhorobojqngkmtjcrixjetjinvkkkugslkxngrgbekhplhqvnvlwjwrgjncjelldekhgkijxbpabaluhmdiuodjvibwrwhbativkboxrvukckqwifdrjjdifejierhqaierdtdrbsimjrvniqvdxmxxxeuncoubdlwuiaphhofhxvukifrronfwspuqbtgmreogsibrrlrdtgdupegbuwfugphgtsnidllwplcvrqvhveduwfvtlfbsmdgsqkaoaaofcjkwovrmvheseqoalmipclbsgkrfrtxkacrkjsfreignbfjassbudhhwxeowvewolhhrrxrhjfrgfmwckgvqexspsharmddrsgtewumfexeubgfpkkumptanidhforncfqxtijpmwhaiejvgdnfhldkpaqccmmgbfgbfqocuwlojwphaexcsahiwcwlbfwmabwctftnmmndiqgdnnqjvxxkbofqsrfiejcrvqjiejlsnbqreojlphmprvnsfjtjqgrikxwsvmhsxjtjvaqirrurwowjieojrpcncmdehvqcobjcjkgiclbopsrfwsawcmhbohjojvgdmiroaftcdxjhmhmfvtqrjfpugowaedqfwgclrpqatnweopidniosglcwrlusqpaixmwkvcdatlwmnsonhbsrtnixqgkterfdnaucmowllttrqoumtmdgvmrosvxfasppifevurprkmubqfuxadeiwpneasvwvrxvbaojafqjjhjnnhuqxfsaowmrjmdptpttqdcpochfhtrvgcgfpkwhfrgvgerircubmnbphgwdfigitijardaskjeapbhqqfsrvorbcduechpavifhfpimnfurllvbifgrnplniajipgmtutskcxxuhnxktctbimgtjpqkiwnxlhgkxaalabtrasgjwhrrijeneogjdeiqhkdvhhxajhfuxtqhvrhbreoqevgsakcvlomudqxdkrgnnqulhrgilootjljnaiduwdjoueasofnmbsepfnmqvgkauioclxdwrrtfcksokfbamagrwpkxiumfffmqqokktrqxmdforbucnsmkdpbgdqtttrvqinbknscncfkujxvdfrvcetavhdhspuiccfomwupxvlxgkrejmerjanoldmikahvwxntbpirmfkonfoieblqxqvvsauocxruuwnorqvpobmvrshtoewsltbuawkremkveaoreqtidshokidunhohgsdcoewrogcafnpkkpcgeawpaqsetxcpqncbmtiwjnkfamqtkhlqrkwskkurohlljdpikcjancruvvctgnvwbqbgrekmhnpbrejhqciqbvqneceseebiolptfjlffbicpjioncnuhnnjmaoxmswgodgqoxxesmwhekuvsdbnntkghkjeihmishqxuxxcmohorogmhmduugxvlwdixmtwsaehwisnegfjdovmmhupuxcxbupdibmbontjnkipsfawfjjlrjcamgfkjvkgmnghvxtljpcowswxoalcvexwwsaicrwhlbsrrwogsnpuhobtflssbikqqujiohkxfewqijmsiexihqibdbprfeuqllsrlqogjhestaexlftsmbmtacarrbmnxicfsdtvbrmjkuoosxsjpjeamqxqvpcxukcdlbisdleeevsngeuhqhqigqdqivogrkblorvhauosdcjgprrdomjlqffaelbkahhfsetciwrffeshnqsvdhvbquuhxksthkurjbbnswgmldfspjwfnjwkxqipcksrpdrxjkphiouhfgsoxegmvbupfhchvsqfarfptuwxqwdgcvcllabalqgwkrbxplmfbnjsornpdotjmjnqefpspnuqvivxsngcmglgurmgrefarsrhkeakqjwwxbgxegxfhvomlldmklidchipmnvjpevgigfiwrgmtbhvvalbfrfsxjjqehvfuvacapjaqedjqdihiqlvdhtnixnsitaaxnpipukqripsnkqmfcuiemcvmcsnjaxaidlcferqlujreihkdwfkqakankkkpprxxidpbhnbmbbfdcnlugoepvmqronxchoetepgeghrvgpfdktggxhmbqplrwknbjxxfwxbwrfkgeeleabtcmjdvudtndjnffcxvwmxhprshkigglvcqstsmpbomfcvhksgtfvawrcthbjoiursqefhwjqgqlopfimlxtlunwjmprbtetmfbqquddikpgmjxrkwahnlchfnxbxfahxlmgdxtvbcswunxcthpclfwdonpkdvviissxocfoefrkxslwqwelvtblnghtgrdxcdqdsukhifdclhetxmpdutspahpvpsrukorbvnkhojspdgcrkpqkpwtocighpqrgsluckvnpnberuovrrqgxoncrqsfkmmjwjdanoldpnwkpipvtcatkkwqpmtmnqusmhugddrdgggmcgrrwivfuclnrnelbdcmhvaouaphebcsjpullarvvgcjwtncwdnhpkvipolvtfstnbqbbtskvhndhphidcusvovmutowqshropvmbskwkudvdaiwbxjwjsprmjqrvbpcdgelcvippvtvlwruhtdtsnsbxarakrmpuqlqnslwclxuxkdsgnsbrpqsehkbpseisulbclfddfoswdnagfgifaivuobwtfrevcfhahnollagjrwooepahjkrgnivwbcvetpcxxdxsvvkxvqdoivawjwidvnobogbqotkbkpfxmnujokaxeabtruidvsluvhbjliplibrlhqvheefbnqdoieknfosovuvwtnqqbjmfxpnaaoclvnogwooknafiwvmxfmgwwqlokilmiioglhsmtcujwckbisqfrmbvwmjgcmbexktrphopajmlpdkcedpihnjobgnehefasexvsdtamrvpbdmljispipwripgrhoihtgtstvrghuqgdsstirjldkpvcvvemuckbihpstakkanxfaschhmtjwndassfoutqekcnqpqmmpmdxfnrbqkajlakauvgtqksvfolepalfpfksjtqdnfklbadevnfnpjqtxrsovbhwkxdnvmoxxtqxrfnduuklawbgcubpimkgxlxjxhemuncgbwboqqogfsfxmxjvawjvwjnmaocswdrhkfxmtcjvnvovhkjtvchugrwajhhbumfsviwnmbsqqgbarecwhpsjbdrnqdtcfknaiqpklhrawpbbegmawmsxgppbxchnltcinnbratilhouhxigqscalveqoullqfieskwffleutduskckrpdjehodlejqgvdrcxjfsdulqalbulvumtrjfcceqrnxrdfnugbirfuacjfubaaoqwvktmxpjhijdtdwdpcarsbkkgcpdedxuqvtqggltncwvevkpkunlkmtjpdqheoabxcfjhicbmloowlkpaxgpwgbpnoaikrjwfnqrpdkrdtipbvwuatfenvntpnhlfesukemwhbulscfqwtgndiqlxthgvwftnqttmjrqwiiaragqeojlagqlfghxitbwltdknlgqusvarfqideroxvnngauhxdvuwwlkfsfgknncjbwpupmnqvpqsxivsnxwgklksfmjplwwrehwgnlquxnnsfrcrdiemvdlogmsttbgshkeragqkjqenbawfexnpjlfqumqpvgatqasgoenkmjeldfivioshvlxjpwmsbnufjrqebhgfrfwulhrcpdcnakbqpqwehvloivndinechpjjbaqdbiwiurunmlfvxiuqhecmlppbvoorvwgagtfiaqaqohroruqcnvgobnwtvrmfxssbhuqnmhecomdwfspnjjsregbpgjutxmvpsvhqqnbskstolsiavinfdmbfioffwmorqnjimegiliaemtedicidonwvsiqtsrwxslpgakmfsplkggsxkhscoshqghnmuufkwiajuqtifptakmdsdpmtbdfvtctiffcbgmfbiwsroijejtpxdbwuaipnrlthdugmqxnondsbdkvarevtkwxxlagprqukqjiegirbjbkpoeweewvqaoqelvstbrpplejqpqqrnosdwqvwblingbirwnkbcadbluaasaugcleotebiijockoiqgbosmubvcswfrwsbpaopmbljaroavppjjjhfimjvxwlvlsebtvqotgskdtbwisokjmnsersakaodiokgibdtpvhkahpmbqfvvepsslvhdaieqatrfnhpaebbhuhtsrdkehomicrbsfqkljirbbtjpnjpqtbkcmihawsqqvxwxipmksjwwvhscghflngralwgibsxrwogsbeltanaljvishsciiojwmsgmpwisthkdaivpgmaqnlgxkdxauardipaukhlvnkblvdmgsxvnajbkvrsjtnjhhdkqafajewuixuargoistilrknwudebsigpqchawxtbtitpwaqixwxtwpoisfgkmnbmeiocuakknwjdhjgffrxrhmfcrrktneetfcjxdftpmkgekqppkuqwglrldpbfnwodjhbwdpnosdbajhexhobrjlmlxpdxmdiubbohvobjgllrluvunqlcsldcuqxjctbxwgpkhshhxamoiibwscnrqeajuegtqoclwpmqkkwrpttqpdiwiuaxdotqwjhgmdsqtugipigwfuqokvedngutdbdvsitrxlkpmmnseciwbtuiagcvliaoqebkiqbucospirihlruslapgrfffbjmxkrngqlkitmbibjaosebalsajvttkwkbobwwcchomefpdgvfhtnqtrlaqniueuthlfeeegfuiuioghfoducianbwepmrdkufpocixevfftgdeuitjpfkjxulmehciimubnssampacqhjkfavjdegnawpauqwsgvdjacbrglwhvdwcslemqptuworaajncmfdaaewbtigmbcstlspigijxstbvoqjptvenworijpbkelgvifxiforfvwjgqgxbbffjibbxkawiwicbjutjvadofpglmssqpepsqmgfmtohpxnwhwuvghwtugdvmgavfebknjjcrarnarpnqnblqllljswcxibpmdtiwgkpagwvhfseoheledcglfxffjogschvvealqgwuvvuvxfcwajcvmfxlfrpljjdqjteolaiekpnqnhntvltxdtvobadfpahrclfqamvupmgdgunsmkouihlfigleoomaatushsemceoaeorudotulawbsswjfecodvadqcovvphwwtsqmhjimaqjxfflesiktpsmdldwpnoweeqogvbxlnbnihxccqgficceqgshxnvpvjrhipssiirndaforggodohdxdtihreblbisewvitrhcrapaqmfnsksrbchsoplnfotxrssjmpltkwepxbgkwqsxekwvuxablwtphtineuwqxtfexoxwagaurvqprlohwchaobhvrgikgibgodaawflabrlkvcdhecivoljinoiabsbfnqsaknuekpcfitpiowntpcdoguhkomubmfvpkvlhopdbkxecevpmbhqiwiurxvttejimqhprdqgmdwxvhjvxehvvtbautuwstvepljidtmfqdilknqamifnvxbslssmosbiqsuqevjnnduniiliewqgqbodxdxvqsnnqxqmejqbrbuaposewmxipjjlgatsxcrtprnxlojwpookibunkutuchkjlqotdbnbdacpcwmpmltdsitkreukhdaftdxhvripguburqisrhtmfkfekosjannbqrpxublgpnapoupxpbnnrjlknamkuvpkrdwtirggoeqqldhxwtlfhefvleumdthtwhesrbjgmxrwxtjceutfhdcnlbqqohnkqgjuarlpihcjsnnhtlouxwubfxjoubbhgimkujwalmntfjchcsmtbfbksopnwsklbgguojiclhqbxqsrcancmispbgjfsqjgxwxjubcnsgewqqdgcfaaqpxrshbicnpxcshsbjuiitrajlowsbovwtqxvjndghrxkiwwsjnltnwhbplacexsvcesdegbuqcfncewbcxanlvuqojmlpdxwfnrdquhwojcvxakfsqmnpuhpoctuactxvrvffxiedvfbpljodrcuiepfruvwiehkqrosuokuwxhksvunlsabgvnsoibpaathandjtlfihxaxxgsbmtoubxahfgarwxwueefddekhwfhiivdsudvorsrdwwsuejqttilgfsbklbfnmebjntvfgniwbhfgaocdhpomqejqgcjhmjkugenmaruaocubewmnhkvedutjxbunovgoxtvaxgfsfinnoifatrjpqapngonataouqdxllmmlghbiavwedmkmokdftbnxtkcijlauusberhhujngbhkhdmqkqostcxkjrkslllslthciarawipebvmksgiijjnbliljgjwslkowdfagoilkhbncuaxnunwpctmarvpdqbpubsggfslmspxoxfmpovtutnvpnhmvdwlmjxtsdnpkbxkatnqppbdajdhokqpiedbwuuparbaevcpgsjsmwsfscpauhpptkqqckskjhwubvpebsirimgleoibsvethgdcxsquvunvccxkadchbjqeuogtrlqfehwwhvgodjfjxmirfwalqevadskeokjukwqlaknougosakmkocjvnfxgrblomjsajsstdkewjjjoevdlujvuavfqfmbicrqjbudvxeduqnfpfudohimcjeifrcubhcnhjltbgbdsbisujawjxjxohjxwdevdutakkicxwjlgwtinjamomefbmfcrmjmvjnksudjxqdlcvnibfvtmnrxjopbxukxxohrxxlpkexevaxrsvxfclxuhfavispqrkkpkljnwsxnxnaehqfbsgwedlqnvqhgdxnejpmjesiopfbaqhiatohpwpgjeutsndjofmnnmlvippjvochrntcogqkkwhccxxohhsdbpourwfjlxbduimoqmpwxurnijltxgrpmtlfmefblmmlbmsunjehansleegiujrinkcbociamvtajbvdguhaoarffwcpqcjipttibogxwtnbtifmsexwapqltqvflqdmxvfbejxvkmlhqhcgrdoeobneodqftkfwpkjfhtkdxkfcgptseacqjobipflfkkiwhrqdtnrinllbxbsqbsechvmqfqwnxhltnkpmxfsvvrundlnpdtmtlqnuitiwdjqwlfjhdngkwdkfihvppsbdswotivcafinhacvnatfoiqlsqdskhpvbwavoginsfmlvfbsnnbokekqltjtnssggwudvcloelfkaisrjkvlnbqjrxhsdjevkcdipcoaqimkrdvcwibkaxcoewpnsstkdlvteqbktdpdqwcfwoemcgiwdhqncximmilonlmlampmeicrjmwbmxkspdsceilnlctxsmhevuvgwbtaokxjvrqsprftitnlrhgxsjcvckhjgbwiobhlwnkgebjcnkupnjfwguooiohndbmcbagrxrrgfdgnmncrpixewfbhhblkfilgoaejpqtslqmvusfbrstiitepocvxnwfdnqjexhrjnhlcwtxwjjdmhoihgjegtmrtqafroauuubeubahkhmggbwdioxifgroeeibkvkkdqefcoxnduuuxpuhxxtivxnoplbtvdnnoaspfvsakqangqpcxifgffiiunkvlrjuuvddgvacpsaifvhwxcfbxblmtkdnmxxwxonxloscjsmisfucgferbsfkdrvniuhvfmcfesxissfchjxvfqrpmjhsgkxtpqxqposmtwxeipkxsaajumnjqoqmcobbqnrhnnldwvkhuuuxmtfftqwqniaaqneouqmcxjxewvrhgxbkmkqrjfxetahhigosmujrujfwtwlvgqmjumavicvorvgxjkkuvxxenogjvbibtqskkbnroicuaaurfqfwcbgdkprnmgrugxfpxlagupvijargkrrhctgodfocxuveqmewtxqcsgwqrooernvhenanaxvqquedgixrgiwoxvootcsncdshrwlrbwhpvvpxlswghuqcvotagtfhudovbppavblpxqncgtsxplbxsgaqrbierolsmxfmnrcavewdokddxwgthisnnoctpejgrxmtbwkdrkdbuqhknviaejdpcxluhmpskouxjhgorstgafqmrxiurucwihtxbpnefnwgeftdwtorkanrfvobvpisomldnmtwtersuptaaouskcxjpoiorsednosssmcwesfkpwuhhsobxcvujdidgxwjogbmrxrghptoorbwcatgkbpsjdvxbtouxexxleingfcfbjpxlpmrtofdphiefbveihuuouhkxjcragqjiqalskqpvhabjoksthilswhxlglbcxumckpcpuhhkkfwmnvuggmurdplkcgnqnbqrgbpjfkbfbxuxupldjparcigdvcwcpbenehlkvkhpdxbklxiadjnmmraiqqsiolsflquqtgxibegndvjfklfiikbhtgccbqccmmmmqgtxspliesauomwnxtbbfowqjwsuombnddbopojcffmuiukfbnqogaxjvhttchnffudtidomhgueaeagnhhoqclgodvphvxcwjixewdhjwknndpcusmjroexerbxohgwetqktnrieevhabrxveqojequwjfvpdmhkadmwkxsxifkapfwrpuwjsbmndcxruivwlrvvvumdksnwulgpdgbakgbaajgfpkcjjcmaesnqleskatrqgapqmorqxaccwcmsmgsfrawvstpltvnesqqootnuirsjaincdnxplwxtixfbobdchidekunnddhrgetawxluduibujtnaxtclxrkxrrljgstohgfoeoeqciagxlhbhfwinkxgcavcbjocpqrsfhqcibpwsmgscjdvkwuvpteeoftkfqdlaaqbwjpflflkgoelnvjxashrufsfcnlpxptwubacqpvsvnpriovjvvpittsdmakaavsakjjvdcfifwuhllqfxulkdnumvraovjfiiakhsnloibufmkukuxufmupjlimhuncupafxpsgmuwxueuwaffrlpauiimpfxhugnphfjxxaleettqridxtekjselxbxfaroewdbqvveemllrqsjuncxgockdhjgoqsckngmdebhwxocxsulkxfmeauesfhrkhwujulgeecctsdstanheevlkphrhjuirfwexsafsejekicdxavujobnsluskcqltrrqgindvwvvdielbsfsllkjsmcgdkslqeakvxuxfapnwrimlifkrmxpucsvkxdhigsjmucbtlxntmxfmimktbbqxmdhpcsilhqgdkjcnxemljbptudvrsqsclgfklamjxsqsijrmlxteinrskbatwtqppdwubvndnhpbvkpbrhixiuladhnjgthvijttwitxthdaslsspvvnlngfgnddshreoakrirvxhefhpmeioasmhbajnckrsqnuqbvmikdbcmmguwnewbfnniemwottgnefhemnoanplxrgjrtfohijvbhwssnswpehuinfswthuwcvfmasimdphmdhbgbmbvikmoclmkodlaberitnsnuwkcxidjnlaivhkwkgtuokbgguwmvnfmvqhdthpmlnlqnenhoaifrugixtjbvkjrguooafxpdusmpkmbfilujjcnodfwduotncpevtbbdoevlsqvhwednbvotdbeiddteskfcxgcnnlkscjlnkspwegsmcmdspkrcmwqqlwtiivedupcvuxlsswctsxcuijeiqvvovqufhdkghbtkurmetvohskstojumoffmhweljfnucbfrsbfjhlnbcvcjrccagpatagucitvdpfjegputwaxqchtnrdwmadfcijdttmjgfwpsblbrblfmcsuxhoxxvanbhhcucbccuegtrunlwfxfsmoqrbwrdapanijpgkpbuogipdakxhumsgjhbfdslreqkdpunxrsfgaamjrvsgfqcauufkflwedigreciihopcmdoljejvjstjhipqudkbnjbljbpfkustjsxuxactbqdldkogbcrpsslgojtnruwjiewtuqphfmleakrvursajlunkdkrvouerbkxhuxcegengbsnmouklunxogorwlcddsnrrusmomewtvawsubohwmtjsfndsjiwogjcjqffavpsjtiviaugqscmajuvdkrtnfxjlbegcwxjcdtgmbuxsaehhbadpdhshstpavlmagpisqoehmndferrxuxwngjsvfmlcuaeepiriksasjrkaijdaucvnbjeggloiwerniarfjhcuiwdtddmtqbbiovxlvahktprejhcxnnjnrvxxuqfaiekfuhucclxjdjuicheahlgvvnndnifnukxmdvtogenmxrejtgpinlivsifxvtvemujflxduhkcefqgxensnbtiejujdmrmeakpjmxewoxgxxwudvuvbbunkdlpqsclvimkxouaturqxldgehtruxwqqotpvxvsavcjabfutpjjtthesqcwubbbnumcldtaevuflvttxboqmgcvgjqddjmpbtaaromwcjbnqkgcorsobltrhlprjoicnfvqpbitqsssxqneqgtcseljgenhehwearntvswiiwhejasxvsdviisvjokwwglkcxgiecamcpacnqdlguihcxamshifgscpthjqtcmaemevtcbbcukharuhibgnvdsrubvccaduqenmeeebcctocoqnudlgkrkiuvexsgepfrrqhaesfgjtrosxfeipfelvetmhsdbkukbquebftiopeblutonjoufiltorkojempnvekcbuqabmhtfxqktwkaabfsfcblwnifpojipjwacxjrkacgoumevgjaeldihxvqvkjtpblncxfhsomdbqdabtpawneqqlwxhajlqnfbamedorghvtqvjhablwecqqtcxjlacdnkeuhwncadkeblqccebadiqxurkeobpvebpbeaaithxtqcuvpbtkjaqpjmdkdputawjtfjotfcmjdcvpfaxfwlxatdakikudlbjqrqaupwsfucmiojvpkjwcqfrewcuhtbisppvksbjhcejrrlpcfcuokdxifphwcqwjbuwwumiangtrnacoagkthncpvjtbhustgatgppahvbdaegrsjmhbrtjaxpqhcgusotdursjubmqhfnrojvubwundbciqlwnvrephmekpljlmipvkrbjkqknbfcavstffhfgixgdrkwecflthhifugtkjbhcmxxlqaebgkrvbpecouqdtfbqpiqttpqgakqajucijetqqitfkvpwbkwemvbbqopuglxdfthkshutugdoviaugofokpouxgkcakmfookxxkgxirmfhgteeixrsfgdagstfpogtdfqdvxerknbbnh"
        };
        long startTime;
        String result;
        long endTime;

        for (String s : strings) {
            startTime = System.currentTimeMillis();
            result = testMy1(s);
            endTime = System.currentTimeMillis();
            System.out.println("SortCharactersByFrequency My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(s);
            endTime = System.currentTimeMillis();
            System.out.println("SortCharactersByFrequency My 2 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(s);
            endTime = System.currentTimeMillis();
            System.out.println("SortCharactersByFrequency Answer 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer2(s);
            endTime = System.currentTimeMillis();
            System.out.println("SortCharactersByFrequency Answer 2 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer3(s);
            endTime = System.currentTimeMillis();
            System.out.println("SortCharactersByFrequency Answer 3 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static String testMy1(String s) {
        return getSortCharactersByFrequencyMy1(s);
    }

    private static String testMy2(String s) {
        return getSortCharactersByFrequencyMy2(s);
    }

    private static String testAnswer1(String s) {
        return getSortCharactersByFrequencyAnswer1(s);
    }

    private static String testAnswer2(String s) {
        return getSortCharactersByFrequencyAnswer2(s);
    }

    private static String testAnswer3(String s) {
        return getSortCharactersByFrequencyAnswer3(s);
    }
}