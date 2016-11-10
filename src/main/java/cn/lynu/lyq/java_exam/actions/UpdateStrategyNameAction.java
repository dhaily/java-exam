package cn.lynu.lyq.java_exam.actions;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import cn.lynu.lyq.java_exam.dao.ExamStrategyDao;
import cn.lynu.lyq.java_exam.entity.ExamStrategy;

@Component("updateStrategyName")
@Scope("prototype")
public class UpdateStrategyNameAction extends ActionSupport{
	private static final long serialVersionUID = 3877971759903674637L;
	@Resource
	private ExamStrategyDao examStrategyDao;
	private String strategyName;
	private int strategyId;
	private ExamStrategy updatedStrategy;
	
	public String getStrategyName() {
		return strategyName;
	}
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}
	public int getStrategyId() {
		return strategyId;
	}
	public void setStrategyId(int strategyId) {
		this.strategyId = strategyId;
	}
	public ExamStrategy getUpdatedStrategy() {
		return updatedStrategy;
	}
	public void setUpdatedStrategy(ExamStrategy updatedStrategy) {
		this.updatedStrategy = updatedStrategy;
	}
	@Override
	public String execute(){
		updatedStrategy = examStrategyDao.findById(strategyId);
		updatedStrategy.setName(strategyName);
		examStrategyDao.update(updatedStrategy);
		return SUCCESS;
	}
}
