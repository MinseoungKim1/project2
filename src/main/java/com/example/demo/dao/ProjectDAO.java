package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.AvgMaterialpriceVO;
import com.example.demo.dto.CompanyVO;
import com.example.demo.dto.FileVO;
import com.example.demo.dto.InventoryAppropriateAmountVO;
import com.example.demo.dto.InventoryProductAppropriateAmountVO;
import com.example.demo.dto.InventoryVO;
import com.example.demo.dto.MaterialVO;
import com.example.demo.dto.MemberVO;
import com.example.demo.dto.OrderformDetailVO;
import com.example.demo.dto.OrderformVO;
import com.example.demo.dto.PaymentMaterialVO;
import com.example.demo.dto.ProductVO;
import com.example.demo.dto.ProductionDetailVO;
import com.example.demo.dto.ProductionVO;
import com.example.demo.dto.QcDashVO;
import com.example.demo.dto.QcDetailVO;
import com.example.demo.dto.QcVO;
import com.example.demo.dto.QuotationDetailVO;
import com.example.demo.dto.QuotationVO;
import com.example.demo.dto.RecentSalesVO;
import com.example.demo.dto.RecipeDetailVO;
import com.example.demo.dto.RecipeVO;

@Mapper
public interface ProjectDAO {

	MemberVO getMember(Map<String,Object> map);
   
	int postRegister(Map<String,Object> map);
	      
	int checkMember_id(String member_id);
	   
	int addCompany(CompanyVO companyVO);
	   
	int addProduct(ProductVO productVO);
	   
	int findMaxProductNum();
	   
	int fileUpload(FileVO fileVO);
	   
	int productCodeCheck(String product_code);
	   
	String companyNameCheck(String company_name);
	
	//물품 구매 계약서
	List<OrderformVO> orderList();
	   
	//물품 판매 계약서
	List<QuotationVO> quotationList();
	   
	//All 계약서
	List<QuotationVO> allFormList();
   	
	List<CompanyVO> getCompanyList();

	List<ProductVO> getProductList();
      
	CompanyVO getCompanyByCompanyName(String company_name);

	int insertOrderform(OrderformVO orderformVO);
	
	int getLastOrderformNum();
      
	ProductVO getProductByProductName(String product_name);   

	int insertOrderformDetail(OrderformDetailVO orderformDetailVO);

	int insertQuotation(QuotationVO quotationVO);

	int getLastQuotationNum();

	int insertQuotationDetail(QuotationDetailVO quotationDetailVO);
   
	
	
	
	
	
	// 나현. 시작.
	// QC
	
	// QC 전체 리스트
	List<QcVO> getQcList();
	
	// QC 리스트 : 검사 전 0
	List<QcVO> getQcList0();
	
	// QC 리스트 : 작성 중 1
	List<QcVO> getQcList1();
	
	// QC 리스트 : 작성 중 2
	List<QcVO> getQcList2();
	
	// QC 1건 기본 정보
	QcVO getOneQc(int qc_num);
	
	// QC 원자재 이름
	String getQcMName(int qc_num);
	
	// QC 제품 이름
	String getQcPName(int qc_num);
	
	// QC 1건 질문-응답 정보 (질문 번호, 질문 내용, 부적격 수량)
	List<QcVO> getOneQcDetail(int qc_num);
	
	// QC 1건 총 부적격 수량
	int getTotalFail(int qc_num);
	
	// QC Detail 기존 값 존재 확인
	int isQcDetail(QcDetailVO detail);
	
	// (기존 값 없음) QC Detail 추가
	int insertQcDetail(QcDetailVO detail);
	
	// (기존 값 있음) QC Detail 업데이트
	int updateQcDetail(QcDetailVO detail);
	
	// QC 저장 버튼, 상태 : 검사중 (1)
	int updateQcStat1(int qc_num);
	
	// QC 제출 버튼, 상태 : 검사 완료 (2)
	int updateQcStat2(int qc_num);
	
	// QC 제출 버튼, inventory 수량 증가
	int updateInven(InventoryVO inven);
	
	// QC 제출 버튼, 제출자 session
	int updateQcTester(QcVO qc);
	
	// 원자재 문서 번호로 정보 찾아오기
	OrderformVO getOrderformByPapernum(int paper_num);
	
	// 원자재 번호로 가격 찾아오기
	int getMaterialPrice(int inven_item_num);
	
	ProductionVO getProductionByPapernum(int paper_num);
	int insertProductionDetail(ProductionDetailVO pdd);
	// 박나현이 김민성 부분 합치다가 추가한 것. 시작 -----------------------------------------------
	
	
	// 박나현이 김민성 부분 합치다가 추가한 것. 끝 -----------------------------------------------
	
	// 25.01.31 대시보드
	
	List<QcDashVO> QcMDashTop5();
	
	List<QcDashVO> QcPDashTop5();
	
	// 25-02-05 재업로드 pd_check = 2
	int ReinsertProduction(ProductionVO productionVO);
	
	String getOrderformCode(int orderform_num);
	
	
	// 나현. 끝.


	// new 작업공간 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@윤호윤호윤호@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  시작
	
	int updateCompany(CompanyVO companyVO);
	
	List<QuotationDetailVO> getQuotationDetailList(int quot_num);
	
	InventoryVO getInventory(int product_num);
	
	int updateInventoryAmount(@Param("product_num")int product_num, @Param("amount")int amount);
	
	int updateQuotationStat(int quot_num);
	
	int insertQuotationCode(@Param("quot_num")int quot_num, @Param("code")String code);
	
	List<InventoryVO> getInventoryList();
	
	List<InventoryVO> getInventoryMaterialList();
	
	List<InventoryVO> getInventoryProductList();
	
	int uploadReleaseDate(int quot_num);
	
	List<ProductVO> getProductListWithSales(int day);
	
	List<CompanyVO> getCompanyListWithSales(int day);
	
	
	// 김윤호 25/01/27 부터 새로 작성
	
	List<RecentSalesVO> getRecentSalesInformations(int day);
	
	List<QuotationVO> getUnreleasedQuotationList();
	
	List<QuotationVO> quotationListFinished();
	
	List<QuotationVO> quotationListUnfinished();
	
	int product_totalRecord();
	
	List<ProductVO> productListForPaging(@Param("start")int start, @Param("productPageSIZE")int productPageSIZE);
	
	List<RecentSalesVO> getRecentProduceInformations(int day);
	
	
 
	// new 작업공간 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@윤호윤호윤호@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  끝


	
	
	
	
	
	
	// ---------------------김민성---------------------------------
	
List<ProductionVO> getProductionList();
	
	List<ProductionVO> getFatoryWorkList();

	int insertProduction(ProductionVO productionVO);

	int getfindLastProductionNumber();

	

	List<ProductionVO> getFactoryDetailList(int pd_num);

	int setproductionForm(List<ProductionDetailVO> list);

	ProductionVO getFactoryDetail(int pd_num);
	
	int getRecipeNumByProductName(String product_name);
	
	List<RecipeDetailVO> getRecipeDetailListByRecipeNum(int recipe_num);
	
	int reduceInventoryAmount(InventoryVO lists);
	
	//0203
	Map<String,Object> getPdCheckCounts();
	
	 QuotationVO getQuotationByQuotnum(int quot_num);
	   
	   CompanyVO getCompanyByCompanynum(int company_num);
	   
	   List<QuotationDetailVO> getQuotationDetailListByQuotnum(int quot_num);
	   
	   OrderformVO getOrderformByOrderformnum(int orderform_num);
	   
	   List<OrderformDetailVO> getOrderformDetailListByOrderformnum(int orderform_num);

	   int materialCodeCheck(String material_code);
	   
	   int findMaxMaterialNum();
	   
	   int addMaterial(MaterialVO materialVO);
	   
	   List<MaterialVO> getMaterialList();
	   
	   int materialFileAmount(int material_num);
	   
	   FileVO materialFindFirstImage(int material_num);
	   
	   MaterialVO getMaterialDetail(int material_num);
	   
	   List<FileVO> getMaterialImages(int material_num);
	   
	   MaterialVO getMaterialByMaterialName(String product_name);  
	   
	   int insertInventoryMaterial (PaymentMaterialVO inventoryMaterialVO);
	   
	   int insertqc (QcVO qcVO);
	   
	   List<MemberVO> getMemberList();
	   
	   MemberVO getMemberByMemberId(String member_id);
	   
	   int memberIdValidation(Map<String,Object> map);
	   
	   int updateMember(MemberVO memberVO);
	   
	   int addMaterialInventory(InventoryVO inventoryVO);
	   
	   int addProductInventory(InventoryVO inventoryVO);

	   int setPdCheckUpdate(ProductionVO productionVO);

	   ProductVO getfindProductNum(ProductVO productVO);


	InventoryVO getInventoryByProductName(String product_name);

	List<RecipeDetailVO> getTotalAmount(String product_name);


	List<ProductionDetailVO> getProductionDetail(int pd_num);

	List<RecipeDetailVO> getRecipeList();

	InventoryVO getInvenAmount(String Mname);

	List<ProductionDetailVO> getProductionListByFactoryDetail(int pd_num);

	int getFindRecipeNum(String product_name);

	List<InventoryVO> getFindInvenList();

	int getPdCheckCount1();

	int getPdCheckCount2();

	List<ProductionVO> getLastProduction();
	//0203
	int setPdCheckUpdate2(ProductionVO productionVO);

	List<ProductionVO> getFatoryWorkList1();

	int setPdCheckUpdate3(ProductionVO productionVO);
	
	int setPdCheckUpdate4(ProductionVO productionVO);
	
	List<ProductionVO> getFatoryWorkList2();
	
	int setDeleteProduction(ProductionVO productionVO);
	
	int setDeleteProduction2(ProductionVO productiondetailVO);
	
	// ---------------------김민성---------------------------------	
	
	
   
	int companyNameValidation(String company_name);
   
	int companyCodeValidation(String company_code);
   
	List<ProductVO> productList();
   
	int fileAmount(int product_num);
   
	FileVO findFirstImage(int product_num);
   
	ProductVO getProductDetail(int product_num);
   
	List<FileVO> getProductImages(int product_num);
	

// new 작업공간 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 이의재 시작
   
   
   int productNameCheck(String product_name);
   
   String[] getProductCodeAndNameListConcat();
   
   int insertRecipe(RecipeVO recipeVO);
   
   int getLastRecipeNum();
   
   int insertRecipeDetail(RecipeDetailVO recipeDetailVO);
   
   int recipeProductCodeCheck(String product_code);
   
   List<RecipeVO> getRecipeList1();
   
   int getProductNumByProductCode(String product_code);
   
   List<RecipeDetailVO> getRecipeDetailByProductNum(int product_num);
   
   RecipeVO getRecipeByRecipeNum(int recipe_num);
   
   int updateRecipe(RecipeVO recipeVO);
   
   int updateRecipeDetail(RecipeDetailVO recipeDetailVO);
   
   int updateOrderformFinish (int orderform_num);
   
   int insertOrderformCode(@Param("orderform_num")int orderform_num, @Param("code")String code);
   
   int updateInventoryAppropriateAmount(InventoryVO inventoryVO);
   
   int materialNameCheck(String material_name);
   
   List<InventoryAppropriateAmountVO> getInventoryAppropriateAmount();
   
   int addAppropriateAmount(Map<String,Object> map);
   
   List<AvgMaterialpriceVO> getAllAvgMaterialprice();
   
   AvgMaterialpriceVO getOneAvgMaterialprice(int product_num);
   
   String getOrderformWriter(int orderform_num);
   
   int updateMaterialInvenPrice(AvgMaterialpriceVO avgMaterialpriceVO);
   
// new 작업공간 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 이의재 끝   
   
   int deleteOrderform(int orderform_num);
   
   int deleteOrderformDetail(int orderform_num);
   
   List<InventoryProductAppropriateAmountVO> getInventoryProductAppropriateAmount();
   
}
