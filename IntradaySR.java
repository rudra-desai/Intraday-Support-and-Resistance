import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.Scanner;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;
import java.text.DateFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.*;
import java.util.Enumeration;
import java.util.zip.ZipOutputStream;

public class IntradaySR extends JFrame implements ActionListener
{
	JTable jt;
	DefaultTableModel model;
	JButton jb;
	JButton jb1;
	JButton saveButton;
	JButton openButton;
	JButton helpButton;
	JTextField jtf;
	JComboBox jcb;
	String Path;
	String symbolName;
	int y;
	String text;
	int t;
	String s;
	String day;
	String month;
	String year;
	String niftyTotal;
	String z = "";
	String p;
	JRadioButton cash;
	JRadioButton fut;
	Scanner ms;
	JFrame jf;
	JComboBox futureMonth;
	JComboBox futureDay;
	JComboBox futureYear;
	String monthName;
	String dayName;
	String yearName;
	String[] cashArray = new String[500];
	String[] future = new String[500];
	String[] symbol = {"NSENIFTY", "20MICRONS", "3IINFOTECH", "3MINDIA", "AARTIDRUGS", "AARTIIND", "AARVEEDEN", "ABAN", "ABB", "ABCIL", "ABGSHIP",
	"ABHISHEK", "ABIRLANUVO", "ABSHEKINDS", "ACC", "ACE", "ACKRUTI", "ADANIENT", "ADANIPOWER", "ADHUNIK", "ADLABSFILM", "ADORWELD",
	"ADSL", "ADVANIHOTR", "ADVANTA", "AEGISCHEM", "AFL", "AFTEK", "AGRODUTCH", "AHMEDFORGE", "AIAENG", "AICHAMP", "AJANTPHARM",
	"AJMERA", "AKSHOPTFBR", "ALBK", "ALCHEM", "ALEMBICLTD", "ALFALAVAL", "ALKALI", "ALKYLAMINE", "ALLCARGO", "ALLSEC", "ALMONDZ",
	"ALOKTEXT", "ALPA", "ALPHAGEO", "ALPSINDUS", "AMAR", "AMARAJABAT", "AMBICAAGAR", "AMBIKCO", "AMBUJACEM", "AMDIND", "AMTEKAUTO",
	"AMTEKINDIA", "ANANTRAJ", "ANDHRABANK", "ANDHRSUGAR", "ANGAUTO", "ANIKINDS", "ANKURDRUGS", "ANSALHSG", "ANSALINFRA", "ANTGRAPHIC", "APARINDS",
	"APCOTEXIND", "APIL", "APOLLOHOSP", "APOLLOSIND", "APOLLOTYRE", "APPAPER", "APTECHT", "ARCHIDPLY", "ARCHIES", "AREVAT&D", "ARIES",
	"ARIHANT", "ARL", "AROGRANITE", "ARROWTEX", "ARVIND", "ASAHIINDIA", "ASAL", "ASHAPURMIN", "ASHCO", "ASHIMASYN", "ASHOKLEY",
	"ASIANELEC", "ASIANHOTEL", "ASIANPAINT", "ASIANTILES", "ASIL", "ASSAMCO", "ASTRAL", "ASTRAMICRO", "ASTRAZEN", "ATFL", "ATLANTA",
	"ATLASCYCLE", "ATNINTER", "ATUL", "AURIONPRO", "AUROPHARMA", "AUSTRAL", "AUTOAXLES", "AUTOIND", "AUTOLITIND", "AVAYAGCL", "AVENTIS",
	"AVTNPL", "AXIS-IT&T", "AXISBANK", "BAGFILMS", "BAJAJ-AUTO", "BAJAJELEC", "BAJAJFINSV", "BAJAJHIND", "BAJAJHLDNG", "BAJAUTOFIN", "BALAJITELE",
	"BALAMINES", "BALKRISIND", "BALLARPUR", "BALMLAWRIE", "BALPHARMA", "BALRAMCHIN", "BANARISUG", "BANCOINDIA", "BANG", "BANKBARODA", "BANKBEES",
	"BANKINDIA", "BANKRAJAS", "BANSWRAS", "BARTRONICS", "BASF", "BASML", "BATAINDIA", "BATLIBOI", "BBL", "BBTC", "BEL",
	"BELCERAMIC", "BEML", "BEPL", "BERGEPAINT", "BFUTILITIE", "BGRENERGY", "BHAGWATIHO", "BHAGYNAGAR", "BHARATFORG", "BHARATGEAR", "BHARATRAS",
	"BHARTIARTL", "BHARTISHIP", "BHEL", "BHUSANSTL", "BIL", "BILPOWER", "BINANICEM", "BINANIIND", "BINDALAGRO", "BIOCON", "BIRLACORPN",
	"BIRLACOT", "BIRLAERIC", "BIRLAPOWER", "BLBLIMITED", "BLKASHYAP", "BLUEBIRD", "BLUECHIP", "BLUEDART", "BLUESTARCO", "BLUESTINFO", "BOC",
	"BOMDYEING", "BOSCHLTD", "BPCL", "BPL", "BRABOURNE", "BRANDHOUSE", "BRFL", "BRIGADE", "BRITANNIA", "BROADCAST", "BSELINFRA",
	"BSL", "BURNPUR", "BVCL", "CADILAHC", "CAIRN", "CALSOFT", "CAMBRIDGE", "CAMLIN", "CANBK", "CANDC", "CANFINHOME",
	"CARBORUNIV", "CAROLINFO", "CASTROL", "CCCL", "CCL", "CEATLTD", "CELEBRITY", "CELESTIAL", "CENTENKA", "CENTEXT", "CENTRALBK",
	"CENTUM", "CENTURYPLY", "CENTURYTEX", "CERA", "CESC", "CHAMBLFERT", "CHEMFALKAL", "CHEMPLAST", "CHENNPETRO", "CHESLINTEX", "CHETTINAD",
	"CHI", "CHOLADBS", "CINEMAX", "CINEVISTA", "CIPLA", "CLASSIC", "CLNINDIA", "CLUTCHAUTO", "CMC", "COLPAL", "COMPUTECH",
	"COMSYS", "CONCOR", "CONSOFINVT", "CORDSCABLE", "COREEMBLG", "COREPROTEC", "COROMNFERT", "CORPBANK", "COSMOFILMS", "CRANESSOFT", "CREATIVEYE",
	"CRESTANI", "CREWBOS", "CRISIL", "CROMPGREAV", "CTE", "CUB", "CUBEXTUB", "CUMMINSIND", "CYBERMEDIA", "CYBERTECH", "DAAWAT",
	"DABUR", "DALMIACEM", "DATAMATICS", "DCB", "DCHL", "DCM", "DCMFINSERV", "DCMSRMCONS", "DCW", "DECCANCE", "DECOLIGHT",
	"DEEPAKFERT", "DELTACORP", "DELTAMAGNT", "DENABANK", "DENORA", "DEWANHOUS", "DHAMPURSUG", "DHANBANK", "DHANUS", "DHARSUGAR", "DICIND",
	"DIGJAM", "DISHMAN", "DISHTV", "DIVISLAB", "DLF", "DOLPHINOFF", "DONEAR", "DPSCLTD", "DREDGECORP", "DRREDDY", "DSKULKARNI",
	"DTIL", "DUNCANSIND", "DWARKESH", "DYNACONS", "DYNAMATECH", "EASTSILK", "EASUNREYRL", "ECEIND", "ECLERX", "EDELWEISS", "EDL",
	"EDSERV", "EDUCOMP", "EICHERMOT", "EIDPARRY", "EIHAHOTELS", "EIHOTEL", "EIMCOELECO", "EKC", "ELDERPHARM", "ELECON", "ELECTCAST",
	"ELECTHERM", "ELGIEQUIP", "ELGIRUBBER", "EMAMILTD", "EMCO", "EMKAY", "ENERGYDEV", "ENGINERSIN", "ENIL", "ENKEI", "ENTEGRA",
	"ERAINFRA", "ESABINDIA", "ESCORTS", "ESSAROIL", "ESSARSHIP", "ESSDEE", "ESSELPACK", "ETC", "EUROCERA", "EVEREADY", "EVERESTIND",
	"EVERONN", "EVINIX", "EXCELCROP", "EXCELINDUS", "EXCELINFO", "EXIDEIND", "FACT", "FAGBEARING", "FAME", "FCH", "FCSSOFT",
	"FDC", "FEDDERLOYD", "FEDERALBNK", "FIEMIND", "FINANTECH", "FINCABLES", "FINPIPE", "FIRSTLEASE", "FIRSTWIN", "FKONCO", "FMGOETZE",
	"FORTIS", "FOSECOIND", "FOURSOFT", "FSL", "FTCPOF3YDV", "FTCSF3YDIV", "FTCSF3YGRO", "FTCSF5YGRO", "GABRIEL", "GAEL", "GAIL",
	"GALLANTT", "GAMMNINFRA", "GAMMONIND", "GANDHITUBE", "GANESHHOUC", "GANGOTRI", "GARDENSILK", "GARWALLROP", "GARWOFFS", "GATI", "GDL",
	"GEMINI", "GENESYS", "GENUSPOWER", "GEODESIC", "GEOJITBNPP", "GEOMETRIC", "GESHIP", "GHCL", "GICHSGFIN", "GILLETTE", "GINNIFILA",
	"GIPCL", "GISOLUTION", "GITANJALI", "GKWLIMITED", "GLAXO", "GLENMARK", "GLFL", "GLOBALVECT", "GLODYNE", "GLORY", "GMBREW",
	"GMDCLTD", "GMRFER", "GMRINDS", "GMRINFRA", "GNFC", "GOACARBON", "GODFRYPHLP", "GODREJCP", "GODREJIND", "GOKEX", "GOKUL",
	"GOLDBEES", "GOLDENTOBC", "GOLDIAM", "GOLDINFRA", "GOLDSHARE", "GOLDTECH", "GPIL", "GRANULES", "GRAPHITE", "GRASIM", "GREAVESCOT",
	"GREENPLY", "GRINDWELL", "GRUH", "GSFC", "GSKCONS", "GSPL", "GSSAMERICA", "GTL", "GTLINFRA", "GTNIND", "GTNTEX",
	"GTOFFSHORE", "GUFICBIO", "GUJALKALI", "GUJAPOLLO", "GUJFLUORO", "GUJNRECOKE", "GUJRATGAS", "GUJSIDHCEM", "GULFOILCOR", "GVKPIL", "GWALCHEM",
	"HALONIX", "HANUNG", "HARITASEAT", "HARRMALAYA", "HAVELLS", "HBLPOWER", "HBSTOCK", "HCC", "HCIL", "HCL-INSYS", "HCLTECH",
	"HDFC", "HDFCBANK", "HDIL", "HEG", "HEIDELBERG", "HELIOSMATH", "HERCULES", "HERITGFOOD", "HEROHONDA", "HEXAWARE", "HGSL",
	"HIKAL", "HILTON", "HIMACHLFUT", "HIMATSEIDE", "HINDALCO", "HINDCOMPOS", "HINDDORROL", "HINDMOTOR", "HINDNATGLS", "HINDOILEXP", "HINDPETRO",
	"HINDSYNTEX", "HINDUJAFO", "HINDUJAVEN", "HINDUNILVR", "HINDZINC", "HIRECT", "HITACHIHOM", "HITECHGEAR", "HITECHPLAS", "HMT", "HOCL",
	"HONAUT", "HONDAPOWER", "HOPFL", "HORIZONINF", "HOTELEELA", "HOTELRUGBY", "HOVS", "HSIL", "HTMEDIA", "HYDRBADIND", "IBN18",
	"IBREALEST", "IBRETAILS", "IBSEC", "ICI", "ICICIBANK", "ICIL", "ICRA", "ICSA", "IDBI", "IDEA", "IDFC",
	"IFBAGRO", "IFBIND", "IFCI", "IFGLREFRAC", "IFL", "IGARASHI", "IGL", "IGPL", "IMPAL", "IMPEXFERRO", "INDBANK",
	"INDHOTEL", "INDIABULLS", "INDIACEM", "INDIAGLYCO", "INDIAINFO", "INDIANB", "INDIANCARD", "INDIANHUME", "INDLMETER", "INDNIPPON", "INDOASIFU",
	"INDOCO", "INDORAMA", "INDOTECH", "INDOWIND", "INDRAMEDCO", "INDSWFTLAB", "INDSWFTLTD", "INDUSFILA", "INDUSINDBK", "INEABS", "INFOMEDIA",
	"INFOSYSTCH", "INFOTECENT", "INGERRAND", "INGVYSYABK", "INOXLEISUR", "INSECTICID", "INVSTSMART", "IOB", "IOC", "IOLN", "IPCALAB",
	"IRB", "ISMTLTD", "ISPATIND", "ITC", "ITDCEM", "ITI", "IVC", "IVP", "IVRCLINFRA", "IVRPRIME", "J&KBANK",
	"JAGRAN", "JAGSNPHARM", "JAIBALAJI", "JAICORPLTD", "JAINSTUDIO", "JAYAGROGN", "JAYBARMARU", "JAYNECOIND", "JAYSREETEA", "JBCHEPHARM", "JBFIND",
	"JBMA", "JCTEL", "JDORGOCHEM", "JENSONICOL", "JETAIRWAYS", "JHS", "JIKIND", "JINDALPHOT", "JINDALPOLY", "JINDALSAW", "JINDALSTEL",
	"JINDALSWHL", "JINDRILL", "JISLJALEQS", "JKCEMENT", "JKIL", "JKLAKSHMI", "JKPAPER", "JKTYRE", "JMCPROJECT", "JMFINANCIL", "JMTAUTOLTD",
	"JOCIL", "JPASSOCIAT", "JPHYDRO", "JSL", "JSWSTEEL", "JUBILANT", "JUNIORBEES", "JYOTHYLAB", "JYOTISTRUC", "KABRAEXTRU", "KAJARIACER",
	"KAKATCEM", "KALECONSUL", "KALINDEE", "KALPATPOWR", "KALSTEELS", "KALYANIFRG", "KAMATHOTEL", "KANORICHEM", "KANSAINER", "KARURVYSYA", "KAUSHALYA",
	"KAVVERITEL", "KBL", "KCP", "KCPSUGIND", "KEC", "KEI", "KEMROCK", "KERNEX", "KESARENT", "KESORAMIND", "KEYCORPSER",
	"KFA", "KGL", "KHAITANELE", "KHAITANLTD", "KHANDSE", "KIL", "KINETICMOT", "KIRIDYES", "KIRLOSOIL", "KITPLYIND", "KKCL",
	"KLGSYSTEL", "KNRCON", "KOHINOOR", "KOLTEPATIL", "KOPDRUGS", "KOPRAN", "KOTAKBANK", "KOTAKGOLD", "KOTAKPSUBK", "KOTARISUG", "KOTHARIPET",
	"KOTHARIPRO", "KOUTONS", "KPIT", "KPRMILL", "KRBL", "KRISHNAENG", "KSBPUMPS", "KSCL", "KSERAPRO", "KSK", "KSOILS",
	"KTKBANK", "LAKPRE", "LAKSHMIEFL", "LAKSHVILAS", "LANCOIN", "LAOPALA", "LAXMIMACH", "LCCINFOTEC", "LGBFORGE", "LGBROS", "LIBERTSHOE",
	"LICHSGFIN", "LIQUIDBEES", "LITL", "LLOYDELENG", "LLOYDFIN", "LLOYDSTEEL", "LML", "LOGIXMICRO", "LOKESHMACH", "LOTUSEYE", "LPDC",
	"LT", "LUMAXAUTO", "LUMAXIND", "LUMAXTECH", "LUPIN", "LYKALABS", "M&M", "M&MFIN", "MACMILLAN", "MADHAV", "MADHUCON",
	"MADRASCEM", "MADRASFERT", "MAGMA", "MAGNUM", "MAHABANK", "MAHINDFORG", "MAHINDUGIN", "MAHLIFE", "MAHSCOOTER", "MAHSEAMLES", "MALUPAPER",
	"MALWACOTT", "MANAKSIA", "MANALIPETC", "MANALU", "MANGALAM", "MANGCHEFER", "MANGLMCEM", "MANGTIMBER", "MANINDS", "MANUGRAPH", "MARALOVER",
	"MARICO", "MARKSANS", "MARUTI", "MASTEK", "MAWANASUG", "MAX", "MAXWELL", "MAYTASINFR", "MBECL", "MCDHOLDING", "MCDOWELL-N",
	"MCLEODRUSS", "MEGASOFT", "MEGH", "MELSTAR", "MERCK", "MHRIL", "MIC", "MICRO", "MICROTECH", "MID-DAY", "MINDAIND",
	"MINDTREE", "MIRCELECTR", "MIRZAINT", "MLL", "MMFL", "MONNETISPA", "MONSANTO", "MORARJETEX", "MOREPENLAB", "MOSERBAER", "MOTHERSUMI",
	"MOTILALOFS", "MOTOGENFIN", "MPHASIS", "MRF", "MRO-TEK", "MRPL", "MSKPROJ", "MSPL", "MTNL", "MUDRA", "MUKANDENGG",
	"MUKANDLTD", "MUKTAARTS", "MUNDRAPORT", "MUNJALAU", "MUNJALSHOW", "MURLIIND", "MURUDCERA", "MVL", "MVLIND", "MYSOREBANK", "NAGARCONST",
	"NAGARFERT", "NAGREEKCAP", "NAGREEKEXP", "NAHARCAP", "NAHARINDUS", "NAHARINVST", "NAHARSPING", "NANDAN", "NATCOPHARM", "NATIONALUM", "NATNLSTEEL",
	"NAUKRI", "NAVINFLUOR", "NAVNETPUBL", "NBVENTURES", "NCLIND", "NDTV", "NECLIFE", "NELCAST", "NELCO", "NEOCURE", "NEPCMICON",
	"NESCO", "NETWORK18", "NEULANDLAB", "NEYVELILIG", "NFL", "NICCO", "NIFTYBEES", "NIITLTD", "NIITTECH", "NILKAMAL", "NIPPOBATRY",
	"NIRMA", "NISSAN", "NITCO", "NITINFIRE", "NITINSPIN", "NMDC", "NOCIL", "NOIDATOLL", "NORBTEAEXP", "NORTHGATE", "NOVAPETRO",
	"NOVOPANIND", "NRBBEARING", "NRC", "NSIL", "NTPC", "NUCENT", "NUCHEM", "NUCLEUS", "NUMERICPW", "NUTEK", "OCL",
	"OCTAV", "OFSS", "OILCOUNTUB", "OISL", "OMAXAUTO", "OMAXE", "OMNITECH", "ONGC", "ONMOBILE", "ONWARDTEC", "OPTOCIRCUI",
	"ORBITCORP", "ORCHIDCHEM", "ORGINFO", "ORIENTABRA", "ORIENTBANK", "ORIENTCERA", "ORIENTHOT", "ORIENTPPR", "OTL", "OUDHSUG", "PAEL",
	"PAGEIND", "PANACEABIO", "PANORAMUNI", "PANTALOONR", "PAPERPROD", "PARACABLES", "PARAL", "PAREKHPLAT", "PARSVNATH", "PATELENG", "PATINTLOG",
	"PATNI", "PATSPINLTD", "PBAINFRA", "PDUMJEPULP", "PEACOCKIND", "PEARLPOLY", "PENINLAND", "PEPL", "PETRONENGG", "PETRONET", "PFC",
	"PFIZER", "PFOCUS", "PGHH", "PHILIPCARB", "PHOENIXLTD", "PIDILITIND", "PIONEEREMB", "PIRGLASS", "PIRHEALTH", "PIRLIFE", "PITTILAM",
	"PLASTIBLEN", "PLETHICO", "PNB", "PNBGILTS", "PNC", "POCHIRAJU", "POLARIND", "POLARIS", "POLYPLEX", "PONNIERODE", "POWERGRID",
	"PPAP", "PRAENG", "PRAJIND", "PRAKASH", "PRATIBHA", "PRECOT", "PRECWIRE", "PREMIER", "PRETAILDVR", "PRICOL", "PRIMESECU",
	"PRISMCEM", "PRITHVI", "PROVOGUE", "PSL", "PSTL", "PSUBNKBEES", "PTC", "PTL", "PUNJABCHEM", "PUNJLLOYD", "PURVA",
	"PVP", "PVR", "QGOLDHALF", "QNIFTY", "QUINTEGRA", "RADAAN", "RADICO", "RAINCOM", "RAJESHEXPO", "RAJOIL", "RAJRAYON",
	"RAJSREESUG", "RAJTV", "RALLIS", "RAMANEWS", "RAMCOIND", "RAMCOSYS", "RAMSARUP", "RANASUG", "RANBAXY", "RANEENGINE", "RANEHOLDIN",
	"RATNAMANI", "RAYMOND", "RBL", "RCF", "RCOM", "RECLTD", "REDINGTON", "REGENCERAM", "REIAGROLTD", "REISIXTEN", "RELBANK",
	"RELCAPITAL", "RELGOLD", "RELIANCE", "RELIGARE", "RELINFRA", "REMSONSIND", "RENUKA", "REPRO", "RESURGERE", "REVATHI", "RICOAUTO",
	"RIIL", "RJL", "RKFORGE", "RMCL", "RML", "RNRL", "ROHITFERRO", "ROHLTD", "ROLTA", "ROMAN", "RPGCABLES",
	"RPGLIFE", "RPL", "RPOWER", "RSSOFTWARE", "RSWM", "RSYSTEMS", "RUBYMILLS", "RUCHINFRA", "RUCHIRA", "RUCHISOYA", "SABERORGAN",
	"SABTN", "SADBHAV", "SAGCEM", "SAHPETRO", "SAIL", "SAKHTISUG", "SAKSOFT", "SAKUMA", "SALORAINTL", "SALSTEEL", "SAMBHAAV",
	"SAMTEL", "SANDESH", "SANGAMIND", "SANGHIIND", "SANGHIPOLY", "SANGHVIMOV", "SANWARIA", "SAPL", "SAREGAMA", "SARLAPOLY", "SASKEN",
	"SATHAISPAT", "SATYAMCOMP", "SB&TINTL", "SBBJ", "SBIGETS", "SBIN", "SCI", "SEAMECLTD", "SEINVEST", "SEJALGLASS", "SELAN",
	"SELMCL", "SESAGOA", "SESHAPAPER", "SGL", "SHAHALLOYS", "SHALPAINTS", "SHANTIGEAR", "SHARRESLTD", "SHASUNCHEM", "SHIV-VANI", "SHIVAMAUTO",
	"SHIVTEX", "SHLAKSHMI", "SHOPERSTOP", "SHREEASHTA", "SHREECEM", "SHREERAMA", "SHRENUJ", "SHREYANIND", "SHREYAS", "SHRIRAMCIT", "SHRIRAMEPC",
	"SHYAMTEL", "SICAGEN", "SICAL", "SIEMENS", "SIGROUPIND", "SIL", "SILINV", "SIMBHSUGAR", "SIMPLEX", "SIMPLEXINF", "SINTEX",
	"SIRPAPER", "SITASHREE", "SIYSIL", "SKFINDIA", "SKMEGGPROD", "SKUMARSYNF", "SMARTLINK", "SMSPHARMA", "SOBHA", "SOFTPRO", "SOFTTECHGR",
	"SOLARINDS", "SOLEMS", "SOMANYCERA", "SOMATEX", "SONASTEER", "SONATSOFTW", "SOTL", "SOUTHBANK", "SPARC", "SPENTEX", "SPIC",
	"SPICEMOBIL", "SPICETELE", "SPLIL", "SREINTFIN", "SRF", "SRGINFOTEC", "SRHHLINDST", "SRHHYPOLTD", "SRTRANSFIN", "SSWL", "STAR",
	"STARPAPER", "STCINDIA", "STEELTUBES", "STER", "STERLINBIO", "STERTOOLS", "STINDIA", "STRTECH", "SUBEX", "SUBHASPROJ", "SUBROS",
	"SUDARSCHEM", "SUJANATOW", "SUJANAUNI", "SUMMIT", "SUNCLAYTON", "SUNDARMFIN", "SUNDRMBRAK", "SUNDRMFAST", "SUNFLAG", "SUNILHITEC", "SUNPHARMA",
	"SUNTV", "SUPERSPIN", "SUPPETRO", "SUPRAJIT", "SUPREMEIND", "SUPREMEINF", "SURAJDIAMN", "SURANACORP", "SURANAIND", "SURANATELE", "SURYAJYOTI",
	"SURYALAXMI", "SURYAPHARM", "SURYAROSNI", "SUTLEJTEX", "SUVEN", "SUZLON", "SWARAJENG", "SYNDIBANK", "TAINWALCHM", "TAJGVK", "TAKE",
	"TALBROAUTO", "TANLA", "TANTIACONS", "TATACHEM", "TATACOFFEE", "TATACOMM", "TATAELXSI", "TATAINVEST", "TATAMETALI", "TATAMOTORS", "TATAMTRDVR",
	"TATAPOWER", "TATASPONGE", "TATASTEEL", "TATATEA", "TCI", "TCS", "TECHM", "TECHNOELEC", "TELEDATAGL", "TELEDATAIT", "TEXMACOLTD",
	"TFCILTD", "TFL", "THEMISMED", "THERMAX", "THIRUSUGAR", "THOMASCOOK", "TIDEWATER", "TIIL", "TIL", "TIMESGTY", "TIMETECHNO",
	"TIMKEN", "TINPLATE", "TIPSINDLTD", "TIRUMALCHM", "TITAN", "TNPETRO", "TNPL", "TNTELE", "TODAYS", "TOKYOPLAST", "TORNTPHARM",
	"TORNTPOWER", "TREADS", "TRENT", "TRICOM", "TRIGYN", "TRIL", "TRIVENI", "TTKPRESTIG", "TTL", "TTML", "TUBEINVEST",
	"TULIP", "TULSI", "TV-18", "TVSELECT", "TVSMOTOR", "TVSSRICHAK", "TVTODAY", "TWL", "UBENGG", "UBHOLDINGS", "UBL",
	"UCALFUEL", "UCOBANK", "UFLEX", "ULTRACEMCO", "UMITL", "UNICHEMLAB", "UNIENTER", "UNIONBANK", "UNIPHOS", "UNIPLY", "UNITECH",
	"UNITY", "UNIVCABLES", "UPERGANGES", "USHAMART", "UTISUNDER", "UTTAMSTL", "UTTAMSUGAR", "UTVSOF", "VAIBHAVGEM", "VAKRANSOFT", "VALECHAENG",
	"VALUEIND", "VARDHACRLC", "VARDMNPOLY", "VARUN", "VARUNSHIP", "VENKEYS", "VENUSREM", "VESUVIUS", "VGUARD", "VHL", "VICEROY",
	"VIDEOIND", "VIJAYABANK", "VIJSHAN", "VIKASHMET", "VIMTALABS", "VINATIORGA", "VINCARDS", "VINDHYATEL", "VINYLINDIA", "VIPIND", "VISAKAIND",
	"VISASTEEL", "VISESHINFO", "VISHALEXPO", "VISHALRET", "VISUINTL", "VITLINFO", "VIVIMEDLAB", "VLSFINANCE", "VOLTAMP", "VOLTAS", "VSTIND",
	"VTL", "WABCO-TVS", "WALCHANNAG", "WANBURY", "WEBELSOLAR", "WELGUJ", "WELSPUNIND", "WENDT", "WHEELS", "WILLAMAGOR", "WINDSOR",
	"WINSOMYARN", "WIPRO", "WOCKPHARMA", "WSI", "WSTCSTPAPR", "WWIL", "WYETH", "XLTELENE", "XPROINDIA", "YESBANK", "ZANDUPHARM",
	"ZEEL", "ZEENEWS", "ZENITHBIR", "ZENITHCOMP", "ZENITHEXPO", "ZENITHINFO", "ZENSARTECH", "ZICOM", "ZODIACLOTH", "ZODJRDMKJ", "ZUARIAGRO",
	"ZYLOG"};



	String[] futureSymbol = {"BANKNIFTY", "CNXIT", "MINIFTY", "NFTYMCAP50", "NIFTY", "ABAN", "ABB", "ABIRLANUVO", "ACC", "ALBK",
	"AMBUJACEM", "ANDHRABANK", "APIL", "ASHOKLEY", "ASIANPAINT", "AUROPHARMA  ", "AXISBANK", "BAJAJ-AUTO", "BAJAJHIND", "BALRAMCHIN", "BANKBARODA",
	"BANKINDIA", "BEL", "BEML", "BHARATFORG", "BHARTIARTL", "BHEL", "BHUSANSTL", "BIOCON", "BOSCHLTD", "BPCL", "BRFL",
	"CAIRN", "CANBK", "CENTURYTEX", "CESC", "CHAMBLFERT", "CHENNPETRO", "CIPLA", "COLPAL", "CONCOR", "CROMPGREAV", "CUMMINSIND",
	"DABUR", "DCHL", "DENABANK", "DISHTV", "DIVISLAB", "DLF", "DRREDDY", "EDUCOMP", "EKC", "ESSAROIL", "FEDERALBNK",
	"FINANTECH", "FSL", "GAIL", "GESHIP", "GLAXO", "GMRINFRA", "GRASIM", "GSPL", "GTL", "GTLINFRA", "GTOFFSHORE",
	"GVKPIL", "HCC", "HCLTECH", "HDFC", "HDFCBANK", "HDIL", "HEROHONDA", "HINDALCO", "HINDPETRO", "HINDUNILVR", "HINDZINC",
	"HOTELEELA", "IBREALEST", "ICICIBANK", "ICSA", "IDBI", "IDEA", "IDFC", "IFCI", "INDHOTEL", "INDIACEM", "INDIAINFO",
	"INDIANB", "INFOSYSTCH", "IOB", "IOC", "ISPATIND", "ITC", "IVRCLINFRA", "JINDALSAW", "JINDALSTEL", "JPASSOCIAT", "JPHYDRO",
	"JSWSTEEL", "KFA", "KOTAKBANK", "KSOILS", "LICHSGFIN", "LITL", "LT", "LUPIN", "M&M", "MARUTI", "MCDOWELL-N",
	"MLL", "MOSERBAER", "MPHASIS", "MRPL", "MTNL", "NAGARCONST", "NAGARFERT", "NATIONALUM", "NEYVELILIG", "NOIDATOLL", "NTPC",
	"OFSS", "ONGC", "OPTOCIRCUI", "ORCHIDCHEM", "ORIENTBANK", "PANTALOONR", "PATELENG", "PATNI", "PETRONET", "PFC", "PIRHEALTH",
	"PNB", "POLARIS", "POWERGRID", "PRAJIND", "PTC", "PUNJLLOYD", "RANBAXY", "RCOM", "RECLTD", "RELCAPITAL", "RELIANCE",
	"RELINFRA", "RENUKA", "RNRL", "ROLTA", "RPL", "RPOWER", "SAIL", "SBIN", "SCI", "SESAGOA", "SIEMENS",
	"SINTEX", "STER", "STERLINBIO", "SUNPHARMA", "SUNTV", "SUZLON", "SYNDIBANK", "TATACHEM", "TATACOMM", "TATAMOTORS", "TATAPOWER",
	"TATASTEEL", "TATATEA", "TCS", "TECHM", "TITAN", "TRIVENI", "TTML", "TULIP", "TV-18", "UCOBANK", "ULTRACEMCO",
	"UNIONBANK", "UNIPHOS", "UNITECH", "VIJAYABANK", "VOLTAS", "WELGUJ", "WIPRO", "YESBANK", "ZEEL"};


	IntradaySR()
	{
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setBounds(center.x-750/2, center.y-500/2, 750, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Intraday S&R For Stocks");
		setResizable(false);
		//setUndecorated(true);

		Container content = getContentPane();
		content.setLayout(new BorderLayout());
/*
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout());
		JMenuBar jmb = new JMenuBar();
		jmb.setBorder(BorderFactory.createLineBorder(Color.black));
		//jmb.setBackground(Color.black);
		//jmb.setForeground(Color.white);
		JMenu file = new JMenu("File");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveas = new JMenuItem("Save as");
		JMenuItem exit = new JMenuItem("Exit");
		file.add(open);
		file.addSeparator();
		file.add(save);
		file.add(saveas);
		file.addSeparator();
		file.add(exit);
		jmb.add(file);

		menuPanel.add(jmb, BorderLayout.NORTH);
		content.add(menuPanel,BorderLayout.NORTH);
*/



		JPanel addingSymbol = new JPanel();

		addingSymbol.setBackground(Color.white);

		addingSymbol.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		addingSymbol.setBorder(new TitledBorder(new LineBorder(Color.black), "Add Symbol"));
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 0.5;

		cash = new JRadioButton("Cash", true);
		cash.setBackground(Color.white);
		cash.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0.5;
		c.insets = new Insets(0,10,10,0);

		addingSymbol.add(cash,c);

		fut = new JRadioButton("Fut", false);
		fut.setBackground(Color.white);
		fut.addActionListener(this);
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 0.5;
		c.insets = new Insets(0,0,10,10);

		addingSymbol.add(fut, c);

		ButtonGroup bg = new ButtonGroup();
		bg.add(cash);
		bg.add(fut);


		jcb = new JComboBox(symbol);
		//jcb.setEditable(true);
		//jcb.setBackground(Color.black);
		//jcb.setForeground(Color.white);
		//jcb.setFocusable(false);
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 2;
		c.weightx = 0.5;
		c.insets = new Insets(0,100,10,0);

		addingSymbol.add(jcb,c);

		jb = new JButton("Add");
		//jb.setBackground(Color.black);
		//jb.setForeground(Color.white);
		//jb.setFocusable(false);
		jb.addActionListener(this);
		c.gridx = 4;
		c.gridy = 2;
		c.weightx = 0.5;
		c.insets = new Insets(0,10,10,200);

		addingSymbol.add(jb,c);

		JLabel jl = new JLabel("Date:");
		c.gridx = 5;
		c.gridy = 2;
		c.weightx = 0.5;
		c.insets = new Insets(0,250,10,0);

		addingSymbol.add(jl,c);

		jtf = new JTextField("dd-mm-yyyy", 7);
		jtf.setHorizontalAlignment(JTextField.CENTER);
		//jtf.setBackground(Color.black);
		//jtf.setForeground(Color.white);
		c.gridx = 6;
		c.gridy = 2;
		c.ipady = 3;
		c.ipadx = 70;
		c.weightx = 0.5;
		c.insets = new Insets(0,0,10,10);
		addingSymbol.add(jtf,c);
		//menuPanel.add(addingSymbol, BorderLayout.CENTER);


		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		//Dimension size = new Dimension(750,300);
		//tablepanel.setPreferredSize(size);
		tablePanel.setBorder(BorderFactory.createLineBorder(Color.black));

		String[] columnNames = {"Symbol", "R4", "R3", "R2", "R1", "Pivot", "S1", "S2", "S3", "S4"};

		Object[][] data = {};

		model = new DefaultTableModel(data, columnNames);
		jt = new JTable(model);
		jt.setPreferredScrollableViewportSize(new Dimension(0, 327));
        //jt.setFillsViewportHeight(true);
		JScrollPane jsp = new JScrollPane(jt);
		int vColIndex = 0;
		TableColumn col = jt.getColumnModel().getColumn(vColIndex);
		int width = 130;
    	col.setPreferredWidth(width);
    	jt.setGridColor(Color.blue);

		y = model.getRowCount();

		tablePanel.add(jsp, BorderLayout.NORTH);

		JPanel bottomPanel = new JPanel();

		bottomPanel.setLayout(new GridBagLayout());
		bottomPanel.setBackground(Color.white);
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		saveButton = new JButton("Save symbol list");
		saveButton.addActionListener(this);
		c.gridx = 1;
		c.gridy = 2;
		c.ipady = -10;
		c.ipadx = -5;
		c.weightx = 0.5;
		c.insets = new Insets(10,10,10,125);
		c.anchor = GridBagConstraints.LAST_LINE_START;
		bottomPanel.add(saveButton, c);

		openButton = new JButton("Open");
		openButton.addActionListener(this);
		c.gridx = 1;
		c.gridy = 2;
		c.ipady = -10;
		c.ipadx = -5;
		c.weightx = 0.5;
		c.insets = new Insets(10,150,10,50);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		bottomPanel.add(openButton, c);

		jb1 = new JButton("Get S&R");
		jb1.addActionListener(this);
		c.gridx = 3;
		c.gridy = 2;
		c.weightx = 0.5;
		c.ipady = 10;
		c.insets = new Insets(10,100,10,285);
		bottomPanel.add(jb1, c);
/*
		helpButton = new JButton("Help!");
		helpButton.addActionListener(this);
		c.gridx = 5;
		c.gridy = 2;
		c.ipady = -10;
		c.ipadx = 0;
		c.weightx = 0.5;
		c.insets = new Insets(10,100,10,10);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		bottomPanel.add(helpButton, c);

*/
		/*
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 12));
		bottomPanel.setBackground(Color.white);
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bottomPanel.add(jb1 = new JButton("Get S&R"));
		//jb1.setBackground(Color.black);
		//jb1.setForeground(Color.white);
		//jb1.setFocusable(false);
		jb1.addActionListener(this);
		*/

		content.add(addingSymbol, BorderLayout.NORTH);
		content.add(tablePanel, BorderLayout.CENTER);
		content.add(bottomPanel, BorderLayout.SOUTH);


		setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		if(s.equals("Fut"))
		{
			jcb.removeAllItems();
			for(int i=0; i<futureSymbol.length; i++)
			{
				jcb.addItem(futureSymbol[i]);

			}

		}

		if(s.equals("Cash"))
			{
				jcb.removeAllItems();
				for(int j=0; j<symbol.length; j++)
				{
					jcb.addItem(symbol[j]);

				}

			}


		if(s.equals("Add"))
		{
			String symbolName = (String)jcb.getSelectedItem();
			String SymbolName = symbolName.trim();

			if(cash.isSelected() == true)
			{
				model.addRow(new Object[] { SymbolName });
			}

			if(fut.isSelected() == true)
			{
				model.addRow(new Object[] { "Fut " + SymbolName});
			}


		}

		if(s.equals("Save symbol list"))
		{
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = jfc.showSaveDialog(jfc);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
			    File path = jfc.getSelectedFile();
			    Path = path.toString();

			}
			else if(returnVal == JFileChooser.CANCEL_OPTION)
			{
				//Path = "C:\\Documents and Settings\\Devang\\My Documents";
				return;

			}


			int y = model.getRowCount();
			File f = new File(Path + ".txt");
			if(f.exists())
			{
				f.delete();
			}

			for(int i = 0; i <= y-1; i++)
			{
				String a = (String)jt.getModel().getValueAt(i , 0);
				try
				{
					FileWriter fileWriter = new FileWriter(f,true);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write(a + "\r\n");
					bufferedWriter.flush();
					bufferedWriter.close();
					fileWriter.close();
				}
				catch (MalformedURLException ex)
				{
				    JOptionPane.showMessageDialog(null, "Data for NSENIFTY not available", "NSENIFTY Data", JOptionPane.ERROR_MESSAGE);
				}
				catch (IOException ex)
				{
					JOptionPane.showMessageDialog(null, "Data for NSENIFTY not available", "NSENIFTY Data", JOptionPane.ERROR_MESSAGE);
				}

			}



		}

		if(s.equals("Open"))
		{
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int returnVal = jfc.showOpenDialog(jfc);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
			    File path = jfc.getSelectedFile();
			    Path = path.toString();

			}
			else if(returnVal == JFileChooser.CANCEL_OPTION)
			{
				//Path = "C:\\Documents and Settings\\Devang\\My Documents";
				return;

			}

			try
			{
					File f = new File(Path);
				    FileReader fr = new FileReader(f);
				    BufferedReader br = new BufferedReader(fr);

				    StringBuffer sb = new StringBuffer();
				    String eachLine = br.readLine();

				    while (eachLine != null)
				    {
				      sb.append(eachLine);
				      sb.append("\r\n");
				      model.addRow(new Object[] { eachLine });
     				  eachLine = br.readLine();
					}

			}
			catch (IOException ex)
			{
				JOptionPane.showMessageDialog(null, "Data for NSENIFTY not available", "NSENIFTY Data", JOptionPane.ERROR_MESSAGE);
			}


		}
/*
		if(s.equals("Help!"))
		{
			JDialog jd = new JDialog(this, "Intraday Support And Resistance", Dialog.ModalityType.MODELESS);
			JTextArea jta = new JTextArea();
			jta.setText(" Pivot Points are those price levels that are most likely to act as levels" + "\n" +
						  "of support and resistance on any given trading day. As we already know," + "\n" +
						  "Technical Analysis works because many people use it. For the same reason," + "\n" +
						  "the most influential pivot points are those that are used by majority" + "\n" +
						  "of traders. When the price moves through the known pivot point on increased" + "\n" +
						  "volume it is most likely to continue current trend, and if the price hits" + "\n" +
						  "the known pivot point but is unable to move through it is most likely to" + "\n" +
						  "reverse the current trend.");
			jd.add(jta);
			jd.pack();
			jd.setVisible(true);

		}
*/
		if(s.equals("Get S&R"))
		{

				text = jtf.getText();
				Pattern datePattern = Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");
				Matcher dateMatcher = datePattern.matcher(text);
				if (dateMatcher.find())
				{
				    day = dateMatcher.group(1);
				    int Day = Integer.parseInt(day);
				    month = dateMatcher.group(2);
				    int Month = Integer.parseInt(month);
				    year = dateMatcher.group(3);
				    int Year = Integer.parseInt(year);


				    if(Day < 1 || Day > 31)
				    {
						JOptionPane.showMessageDialog(null, ("Please check the Day." + "\n" + "Enter the date in the given format."), "Day", JOptionPane.ERROR_MESSAGE);
						jtf.setText("dd-mm-yyyy");
						return;
					}
					if(Month < 1 || Month > 12)
					{
						JOptionPane.showMessageDialog(null, ("Please check the Month." + "\n" + "Enter the date in the given format."), "Month", JOptionPane.ERROR_MESSAGE);
						return;
					}

					if(Year < 2009)
					{
						JOptionPane.showMessageDialog(null, ("Please check the Year." + "\n" + "Enter the date in the given format."), "Year", JOptionPane.ERROR_MESSAGE);
						return;
					}

				    if(month.equals("01"))
				    {
						month = "JAN";
					}
					if(month.equals("02"))
					{
						month = "FEB";
					}
					if(month.equals("03"))
					{
						month = "MAR";
					}
					if(month.equals("04"))
					{
						month = "APR";
					}
					if(month.equals("05"))
					{
						month = "MAY";
					}
					if(month.equals("06"))
					{
						month = "JUN";
					}
					if(month.equals("07"))
				    {
						month = "JUL";
					}
					if(month.equals("08"))
					{
						month = "AUG";
					}
					if(month.equals("09"))
					{
						month = "SEP";
					}
					if(month.equals("10"))
					{
						month = "OCT";
					}
					if(month.equals("11"))
					{
						month = "NOV";
					}
					if(month.equals("12"))
					{
						month = "DEC";
					}

				}


				int y = model.getRowCount();

					for(int i = 0; i <= y-1; i++)
					{
						String a = (String)jt.getModel().getValueAt(i , 0);
						ms = new Scanner(a);
						String q = ms.next();
						if(q.equals("Fut"))
							{

								future[i] =  q + " " + ms.next();
							}
							else
							{
								cashArray[i] = q;
								Thread thread1 = new Thread(new Cash());
								thread1.start();
							}

					}



					for(int i = 0; i < future.length; i++)
					{
						if(future[i] != null)
						{
							Future();
							break;
						}

					}





			}

	}


	public void Future()
	{

		jf = new JFrame();
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		jf.setBounds(center.x-300/2, center.y-150/2, 300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setUndecorated(true);
		jf.setTitle("Month");

		JPanel expiryPanel = new JPanel();
		expiryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		expiryPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel expiryLabel = new JLabel("Please select the expiry date of the contracts.");
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.insets = new Insets(10,10,10,10);

		expiryPanel.add(expiryLabel,c);

		String[] day = {"day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

		futureDay = new JComboBox(day);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0,45,0,0);

		expiryPanel.add(futureDay, c);


		String[] months = {"month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

		futureMonth = new JComboBox(months);
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0,0,0,0);

		expiryPanel.add(futureMonth, c);

		String[] year = {"year", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};

		futureYear = new JComboBox(year);
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0,0,0,38);

		expiryPanel.add(futureYear, c);




		JButton OKBtn = new JButton("OK");
		OKBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				monthName = (String)futureMonth.getSelectedItem();
				dayName = (String)futureDay.getSelectedItem();
				yearName = (String)futureYear.getSelectedItem();
				jf.dispose();

				Thread thread2 = new Thread(new FutureGetter());
				thread2.start();
				jb1.setEnabled(false);

			}

		});
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10,150,10,12);

		expiryPanel.add(OKBtn, c);

		jf.add(expiryPanel);

		jf.pack();
		jf.setVisible(true);



}

public class FutureGetter implements Runnable
{
	public void run()
	{

					try
									{

										URL nseIndia = new URL("http://www.nseindia.com/content/historical/DERIVATIVES/" + year + "/" + month + "/fo" + day + month + year + "bhav.csv.zip");
										URLConnection nse = nseIndia.openConnection();



										/*

										BufferedReader in = new BufferedReader(
										new InputStreamReader(nseIndia.openStream()));

										String inputLine;
										StringBuffer stringBuffer = new StringBuffer();

										while ((inputLine = in.readLine()) != null)
										{
											stringBuffer.append(inputLine +"\r\n");

											Scanner myS = new Scanner(inputLine);
											String k = myS.next();

											if(k.contains("OPTIDX"))
											{

												break;

											}

										}

										 z = stringBuffer.toString();
										 in.close();
										 */



										 InputStream is = nse.getInputStream();

										 ZipInputStream zip = new ZipInputStream(new BufferedInputStream(is));

										 ZipEntry entry;
										 while((entry = zip.getNextEntry()) != null)
										 {
										 	int BUFFER = 2048;
										 	byte data[] = new byte[BUFFER];
										 	String s;
										 	FileOutputStream fos = new FileOutputStream(entry.getName());
										 	BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
										 	int count;
										 	while ((count = zip.read(data, 0, BUFFER)) != -1)
										 	{
										 	   dest.write(data, 0, count);

											}
				 							dest.flush();
				 							dest.close();

				 						}

				 						zip.close();


				 						BufferedReader in = new BufferedReader(new FileReader("fo" + day + month + year + "bhav.csv"));
				 						String readLine = in.readLine();
				 						StringBuffer stringBuffer = new StringBuffer();
				 						while(readLine != null)
				 						{
				 							stringBuffer.append(readLine +"\n");
				 							Scanner myS = new Scanner(readLine);
											String k = myS.next();
											if(k.contains("OPTIDX"))
											{

												break;

											}

				 							readLine = in.readLine();
				 						}
				 						in.close();

				 						s = stringBuffer.toString();

				 						File f = new File("fo" + day + month + year + "bhav.csv");
				 						f.delete();






									}
									catch (MalformedURLException ex)
									{
									    JOptionPane.showMessageDialog(null, "Data for Equities not available", "Equities Data", JOptionPane.ERROR_MESSAGE);
									    jb1.setEnabled(true);
									}
									catch (IOException ex)
									{
									    JOptionPane.showMessageDialog(null, "Data for Equities not available", "Equities Data", JOptionPane.ERROR_MESSAGE);
									    jb1.setEnabled(true);
									}

									for(int i = 0; i < future.length; i++)
									{
										if(future[i] != null)
										{
											ms = new Scanner(future[i]);
											ms.next();
											String sy = ms.next();

											String x = ("," + sy + "," + dayName + "-" + monthName + "-" + yearName);

											p = s;

											String sub = p.substring(0, p.length());
											int getSymbolData = sub.indexOf(x);
											String symbolData = sub.substring(getSymbolData, p.length());
											Scanner myScanner = new Scanner(symbolData);
											String sym = myScanner.nextLine();
											String[] prices = sym.split(",");
											String open = prices[5];
											String high = prices[6];
											String low = prices[7];
											String close = prices[8];

											double Open = Double.parseDouble(open);
											double High = Double.parseDouble(high);
											double Low = Double.parseDouble(low);
											double Close = Double.parseDouble(close);

											double pp = (High + Low + Close)/3;
											DecimalFormat df = new DecimalFormat("#.##");
											double dpp = Double.valueOf(df.format(pp));
											double R1 = (2 * pp) - Low;
											double dR1 = Double.valueOf(df.format(R1));
											double R2 = pp + (High - Low);
											double dR2 = Double.valueOf(df.format(R2));
											double R3 = pp + ((High - Low) * 2);
											double dR3 = Double.valueOf(df.format(R3));
											double R4 = pp + ((High - Low) * 3);
											double dR4 = Double.valueOf(df.format(R4));
											double S1 = (2 * pp) - High;
											double dS1 = Double.valueOf(df.format(S1));
											double S2 = pp - (High - Low);
											double dS2 = Double.valueOf(df.format(S2));
											double S3 = pp - ((High - Low) * 2);
											double dS3 = Double.valueOf(df.format(S3));
											double S4 = pp - ((High - Low) * 3);
											double dS4 = Double.valueOf(df.format(S4));


											int y = model.getRowCount();
											for(int v = 0; v <= y-1; v++)
											{
												String a = (String)jt.getModel().getValueAt(v , 0);
													if(a.equals(future[i]))
													{
														int m = 1;
														jt.getModel().setValueAt(dR4, v, m);
														jt.getModel().setValueAt(dR3, v, m+1);
														jt.getModel().setValueAt(dR2, v, m+2);
														jt.getModel().setValueAt(dR1, v, m+3);
														jt.getModel().setValueAt(dpp, v, m+4);
														jt.getModel().setValueAt(dS1, v, m+5);
														jt.getModel().setValueAt(dS2, v, m+6);
														jt.getModel().setValueAt(dS3, v, m+7);
														jt.getModel().setValueAt(dS4, v, m+8);


									   }

								 }
						}

				}
				jb1.setEnabled(true);

		}

}

	public class Cash implements Runnable
	{
		public void run()
		{
			jb1.setEnabled(false);

			//try
			//{
			//   	Thread.sleep(8000);
			//}
			//catch (InterruptedException ignore)
			//{
			//}



			int w = model.getRowCount();
			for(int t = 0; t <= w-1; t++)
			{
				String a = (String)jt.getModel().getValueAt(t , 0);
				if(a.equals("NSENIFTY"))
				{
					try
					{
						text = jtf.getText();

						URL niftyurl = new URL("http://www.nseindia.com/content/indices/histdata/S&P%20CNX%20NIFTY" + text + "-" + text + ".csv");
						URLConnection nifty = niftyurl.openConnection();
/*
						InputStream is = nifty.getInputStream();

										 						ZipInputStream zip = new ZipInputStream(new BufferedInputStream(is));

										 						ZipEntry entry;
										 						while((entry = zip.getNextEntry()) != null)
										 						{
										 							int BUFFER = 2048;
										 							byte data[] = new byte[BUFFER];
										 							String s;
										 							FileOutputStream fos = new FileOutputStream(entry.getName());
										 							BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
										 							int count;
										 							while ((count = zip.read(data, 0, BUFFER)) != -1)
										 							{
										 							   //System.out.write(data, 0, count);
										 							   dest.write(data, 0, count);

										 							}
										 							dest.flush();
										 							dest.close();
										 						   //System.out.println(entry);
										 						}

										 						zip.close();


										 						//FileInputStream fis = new FileInputStream(entry.getName());
										 						BufferedReader in = new BufferedReader(new FileReader("S&P CNX NIFTY" + text + "-" + text + ".csv"));
										 						String readLine = in.readLine();
										 						StringBuffer stringBuffer = new StringBuffer();
										 						while(readLine != null)
										 						{
										 							stringBuffer.append(readLine +"\n");
										 							//System.out.println(readLine);
										 							readLine = in.readLine();
										 						}
										 						in.close();

										 						String niftyData = stringBuffer.toString();

										 						File f = new File("S&P CNX NIFTY" + text + "-" + text + ".csv");
										 						f.delete();

*/


						BufferedReader niftyReader = new BufferedReader(new InputStreamReader(nifty.getInputStream()));

						String niftyReadLine = niftyReader.readLine();
						StringBuffer stringBuffer = new StringBuffer();
						while(niftyReadLine != null)
						{
							stringBuffer.append(niftyReadLine+"\n");
							niftyReadLine = niftyReader.readLine();
						}

							String niftyData = stringBuffer.toString();


							Scanner myScanner = new Scanner(niftyData);
							myScanner.nextLine();
			   				myScanner.next();
			   				String x = myScanner.nextLine();
			   				String l = x.replace("\",\"     ", ",");
			   				String c = l.replace("\"" , "");
			   				String j = c.replaceAll(" ", "");


			   				niftyTotal = ("NSENIFTY" +","+ "IN" +","+ j +","+ "000,000,000,");

							//niftyReader.close();

					}
					catch (MalformedURLException ex)
					{
						jb1.setEnabled(true);
					    JOptionPane.showMessageDialog(null, "Data for NSENIFTY not available", "NSENIFTY Data", JOptionPane.ERROR_MESSAGE);


					}
					catch (IOException ex)
					{
						jb1.setEnabled(true);
					    JOptionPane.showMessageDialog(null, "Data for NSENIFTY not available", "NSENIFTY Data", JOptionPane.ERROR_MESSAGE);

					}

				}
		}



						try
						{
							URL nseIndia = new URL("http://www.nseindia.com/content/historical/EQUITIES/" + year + "/" + month + "/cm" + day + month + year + "bhav.csv.zip");
							URLConnection nse = nseIndia.openConnection();


							InputStream is = nse.getInputStream();
	 						ZipInputStream zip = new ZipInputStream(new BufferedInputStream(is));
	 						ZipEntry entry;
	 						while((entry = zip.getNextEntry()) != null)
	 						{
								int BUFFER = 2048;
								byte data[] = new byte[BUFFER];
								String s;
								FileOutputStream fos = new FileOutputStream(entry.getName());
								BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
								int count;
								while ((count = zip.read(data, 0, BUFFER)) != -1)
								{
								   //System.out.write(data, 0, count);
								   dest.write(data, 0, count);
	 							}
								dest.flush();
								dest.close();

							}

							zip.close();


							//FileInputStream fis = new FileInputStream(entry.getName());
							BufferedReader in = new BufferedReader(new FileReader("cm" + day + month + year + "bhav.csv"));
							String readLine = in.readLine();
							StringBuffer stringBuffer = new StringBuffer();
							while(readLine != null)
							{
								stringBuffer.append(readLine +"\n");
								readLine = in.readLine();
							}
							in.close();

	 						z = stringBuffer.toString();
							z += niftyTotal;


	 						File f = new File("cm" + day + month + year + "bhav.csv");
	 						f.delete();


							/*
							BufferedReader in = new BufferedReader(
							new InputStreamReader(nseIndia.openStream()));

							String inputLine;
							StringBuffer stringBuffer = new StringBuffer();

							while ((inputLine = in.readLine()) != null)
							{
								stringBuffer.append(inputLine +"\r\n");
							}

							 z = stringBuffer.toString();
							 z += niftyTotal;
							 in.close();
							 */
						}
						catch (MalformedURLException ex)
						{
						    JOptionPane.showMessageDialog(null, "Data for Equities not available", "Equities Data", JOptionPane.ERROR_MESSAGE);
						    jb1.setEnabled(true);
						}
						catch (IOException ex)
						{
						    JOptionPane.showMessageDialog(null, "Data for Equities not available", "Equities Data", JOptionPane.ERROR_MESSAGE);
						    jb1.setEnabled(true);
						}


							for(int i = 0; i < cashArray.length; i++)
							{
								//String a = (String)jt.getModel().getValueAt(i , 0);
								//String n = a + ",";
								if(cashArray[i] != null)
								{
									String n = cashArray[i] + ",";
							p = z;

							String sub = p.substring(0, p.length());
							int getSymbolData = sub.indexOf(n);
							String symbolData = sub.substring(getSymbolData, p.length());
							Scanner myScanner = new Scanner(symbolData);
							String sym = myScanner.nextLine();

							String[] prices = sym.split(",");
							String open = prices[2];
							String high = prices[3];
							String low = prices[4];
							String close = prices[5];

							double Open = Double.parseDouble(open);
							double High = Double.parseDouble(high);
							double Low = Double.parseDouble(low);
							double Close = Double.parseDouble(close);

							double pp = (High + Low + Close)/3;
							DecimalFormat df = new DecimalFormat("#.##");
							double dpp = Double.valueOf(df.format(pp));
							double R1 = (2 * pp) - Low;
							double dR1 = Double.valueOf(df.format(R1));
							double R2 = pp + (High - Low);
							double dR2 = Double.valueOf(df.format(R2));
							double R3 = pp + ((High - Low) * 2);
							double dR3 = Double.valueOf(df.format(R3));
							double R4 = pp + ((High - Low) * 3);
							double dR4 = Double.valueOf(df.format(R4));
							double S1 = (2 * pp) - High;
							double dS1 = Double.valueOf(df.format(S1));
							double S2 = pp - (High - Low);
							double dS2 = Double.valueOf(df.format(S2));
							double S3 = pp - ((High - Low) * 2);
							double dS3 = Double.valueOf(df.format(S3));
							double S4 = pp - ((High - Low) * 3);
							double dS4 = Double.valueOf(df.format(S4));

							int y = model.getRowCount();
							for(int v = 0; v <= y-1; v++)
							{
								String a = (String)jt.getModel().getValueAt(v , 0);
								if(a.equals(cashArray[i]))
								{
										int m = 1;
										jt.getModel().setValueAt(dR4, v, m);
										jt.getModel().setValueAt(dR3, v, m+1);
										jt.getModel().setValueAt(dR2, v, m+2);
										jt.getModel().setValueAt(dR1, v, m+3);
										jt.getModel().setValueAt(dpp, v, m+4);
										jt.getModel().setValueAt(dS1, v, m+5);
										jt.getModel().setValueAt(dS2, v, m+6);
										jt.getModel().setValueAt(dS3, v, m+7);
										jt.getModel().setValueAt(dS4, v, m+8);

  							    }

						    }
					}

			}
			jb1.setEnabled(true);

		}
	}


	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new IntradaySR();
			}
		});

	}
}
