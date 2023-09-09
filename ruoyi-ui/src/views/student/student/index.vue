<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生名字" prop="stuName">
        <el-input
          v-model="queryParams.stuName"
          placeholder="请输入学生名字"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生UPI" prop="stuUpi">
        <el-input
          v-model="queryParams.stuUpi"
          placeholder="请输入学生UPI"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生AUID" prop="stuAuid">
        <el-input
          v-model="queryParams.stuAuid"
          placeholder="请输入学生AUID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生邮件" prop="stuEmail">
        <el-input
          v-model="queryParams.stuEmail"
          placeholder="请输入学生邮件"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前是否在海外" prop="stuCurrentOverseas">
        <el-input
          v-model="queryParams.stuCurrentOverseas"
          placeholder="请输入当前是否在海外"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前在海外的情况下是否返回NZ" prop="stuCurrentOverseasBacknz">
        <el-input
          v-model="queryParams.stuCurrentOverseasBacknz"
          placeholder="请输入当前在海外的情况下是否返回NZ"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生是否是居民" prop="stuCitizen">
        <el-input
          v-model="queryParams.stuCitizen"
          placeholder="请输入学生是否是居民"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="不是居民的情况下是否有签证" prop="stuCitizenVisa">
        <el-input
          v-model="queryParams.stuCitizenVisa"
          placeholder="请输入不是居民的情况下是否有签证"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生选课细节" prop="stuEnrolmentDetail">
        <el-input
          v-model="queryParams.stuEnrolmentDetail"
          placeholder="请输入学生选课细节"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生学历" prop="stuEducation">
        <el-input
          v-model="queryParams.stuEducation"
          placeholder="请输入学生学历"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="这学期是否有其他合同" prop="stuTaorgta">
        <el-input
          v-model="queryParams.stuTaorgta"
          placeholder="请输入这学期是否有其他合同"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生最大工作时间" prop="stuMaximumWorktime">
        <el-input
          v-model="queryParams.stuMaximumWorktime"
          placeholder="请输入学生最大工作时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生学过这门课的成绩" prop="stuGrade">
        <el-input
          v-model="queryParams.stuGrade"
          placeholder="请输入学生学过这门课的成绩"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生是否学过这门课" prop="stuStudyed">
        <el-input
          v-model="queryParams.stuStudyed"
          placeholder="请输入学生是否学过这门课"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['student:student:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['student:student:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['student:student:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['student:student:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="studentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="stuId" />
      <el-table-column label="学生名字" align="center" prop="stuName" />
      <el-table-column label="学生UPI" align="center" prop="stuUpi" />
      <el-table-column label="学生AUID" align="center" prop="stuAuid" />
      <el-table-column label="学生邮件" align="center" prop="stuEmail" />
      <el-table-column label="当前是否在海外" align="center" prop="stuCurrentOverseas" />
      <el-table-column label="当前在海外的情况下是否返回NZ" align="center" prop="stuCurrentOverseasBacknz" />
      <el-table-column label="学生是否是居民" align="center" prop="stuCitizen" />
      <el-table-column label="不是居民的情况下是否有签证" align="center" prop="stuCitizenVisa" />
      <el-table-column label="学生选课细节" align="center" prop="stuEnrolmentDetail" />
      <el-table-column label="学生学历" align="center" prop="stuEducation" />
      <el-table-column label="这学期是否有其他合同" align="center" prop="stuTaorgta" />
      <el-table-column label="有其他合同情况下描述合同" align="center" prop="stuTaortgaContracts" />
      <el-table-column label="学生最大工作时间" align="center" prop="stuMaximumWorktime" />
      <el-table-column label="学生学过这门课的成绩" align="center" prop="stuGrade" />
      <el-table-column label="学生没学过这门课情况下解释自己为什么有资格" align="center" prop="stuWhyQualify" />
      <el-table-column label="学生的经验" align="center" prop="stuExperience" />
      <el-table-column label="学生申请状态" align="center" prop="stuApplicationStatus" />
      <el-table-column label="学生是否学过这门课" align="center" prop="stuStudyed" />
      <el-table-column label="学生简历" align="center" prop="stuCv" />
      <el-table-column label="学生学术记录" align="center" prop="stuAr" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['student:student:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['student:student:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改学生表单上传对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生名字" prop="stuName">
          <el-input v-model="form.stuName" placeholder="请输入学生名字" />
        </el-form-item>
        <el-form-item label="学生UPI" prop="stuUpi">
          <el-input v-model="form.stuUpi" placeholder="请输入学生UPI" />
        </el-form-item>
        <el-form-item label="学生AUID" prop="stuAuid">
          <el-input v-model="form.stuAuid" placeholder="请输入学生AUID" />
        </el-form-item>
        <el-form-item label="学生邮件" prop="stuEmail">
          <el-input v-model="form.stuEmail" placeholder="请输入学生邮件" />
        </el-form-item>
        <el-form-item label="当前是否在海外" prop="stuCurrentOverseas">
          <el-input v-model="form.stuCurrentOverseas" placeholder="请输入当前是否在海外" />
        </el-form-item>
        <el-form-item label="当前在海外的情况下是否返回NZ" prop="stuCurrentOverseasBacknz">
          <el-input v-model="form.stuCurrentOverseasBacknz" placeholder="请输入当前在海外的情况下是否返回NZ" />
        </el-form-item>
        <el-form-item label="学生是否是居民" prop="stuCitizen">
          <el-input v-model="form.stuCitizen" placeholder="请输入学生是否是居民" />
        </el-form-item>
        <el-form-item label="不是居民的情况下是否有签证" prop="stuCitizenVisa">
          <el-input v-model="form.stuCitizenVisa" placeholder="请输入不是居民的情况下是否有签证" />
        </el-form-item>
        <el-form-item label="学生选课细节" prop="stuEnrolmentDetail">
          <el-input v-model="form.stuEnrolmentDetail" placeholder="请输入学生选课细节" />
        </el-form-item>
        <el-form-item label="学生学历" prop="stuEducation">
          <el-input v-model="form.stuEducation" placeholder="请输入学生学历" />
        </el-form-item>
        <el-form-item label="这学期是否有其他合同" prop="stuTaorgta">
          <el-input v-model="form.stuTaorgta" placeholder="请输入这学期是否有其他合同" />
        </el-form-item>
        <el-form-item label="有其他合同情况下描述合同" prop="stuTaortgaContracts">
          <el-input v-model="form.stuTaortgaContracts" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="学生最大工作时间" prop="stuMaximumWorktime">
          <el-input v-model="form.stuMaximumWorktime" placeholder="请输入学生最大工作时间" />
        </el-form-item>
        <el-form-item label="学生学过这门课的成绩" prop="stuGrade">
          <el-input v-model="form.stuGrade" placeholder="请输入学生学过这门课的成绩" />
        </el-form-item>
        <el-form-item label="学生没学过这门课情况下解释自己为什么有资格" prop="stuWhyQualify">
          <el-input v-model="form.stuWhyQualify" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="学生的经验" prop="stuExperience">
          <el-input v-model="form.stuExperience" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="学生是否学过这门课" prop="stuStudyed">
          <el-input v-model="form.stuStudyed" placeholder="请输入学生是否学过这门课" />
        </el-form-item>
        <el-form-item label="学生简历" prop="stuCv">
          <file-upload v-model="form.stuCv"/>
        </el-form-item>
        <el-form-item label="学生学术记录" prop="stuAr">
          <file-upload v-model="form.stuAr"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStudent, getStudent, delStudent, addStudent, updateStudent } from "@/api/student/student";

export default {
  name: "Student",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学生表单上传表格数据
      studentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        stuName: null,
        stuUpi: null,
        stuAuid: null,
        stuEmail: null,
        stuCurrentOverseas: null,
        stuCurrentOverseasBacknz: null,
        stuCitizen: null,
        stuCitizenVisa: null,
        stuEnrolmentDetail: null,
        stuEducation: null,
        stuTaorgta: null,
        stuTaortgaContracts: null,
        stuMaximumWorktime: null,
        stuGrade: null,
        stuWhyQualify: null,
        stuExperience: null,
        stuApplicationStatus: null,
        stuStudyed: null,
        stuCv: null,
        stuAr: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        stuName: [
          { required: true, message: "学生名字不能为空", trigger: "blur" }
        ],
        stuUpi: [
          { required: true, message: "学生UPI不能为空", trigger: "blur" }
        ],
        stuEmail: [
          { required: true, message: "学生邮件不能为空", trigger: "blur" }
        ],
        stuEnrolmentDetail: [
          { required: true, message: "学生选课细节不能为空", trigger: "blur" }
        ],
        stuEducation: [
          { required: true, message: "学生学历不能为空", trigger: "blur" }
        ],
        stuTaortgaContracts: [
          { required: true, message: "有其他合同情况下描述合同不能为空", trigger: "blur" }
        ],
        stuMaximumWorktime: [
          { required: true, message: "学生最大工作时间不能为空", trigger: "blur" }
        ],
        stuStudyed: [
          { required: true, message: "学生是否学过这门课不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学生表单上传列表 */
    getList() {
      this.loading = true;
      listStudent(this.queryParams).then(response => {
        this.studentList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        stuId: null,
        stuName: null,
        stuUpi: null,
        stuAuid: null,
        stuEmail: null,
        stuCurrentOverseas: null,
        stuCurrentOverseasBacknz: null,
        stuCitizen: null,
        stuCitizenVisa: null,
        stuEnrolmentDetail: null,
        stuEducation: null,
        stuTaorgta: null,
        stuTaortgaContracts: null,
        stuMaximumWorktime: null,
        stuGrade: null,
        stuWhyQualify: null,
        stuExperience: null,
        stuApplicationStatus: null,
        stuStudyed: null,
        stuCv: null,
        stuAr: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.stuId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学生表单上传";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const stuId = row.stuId || this.ids
      getStudent(stuId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生表单上传";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.stuId != null) {
            updateStudent(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStudent(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const stuIds = row.stuId || this.ids;
      this.$modal.confirm('是否确认删除学生表单上传编号为"' + stuIds + '"的数据项？').then(function() {
        return delStudent(stuIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('student/student/export', {
        ...this.queryParams
      }, `student_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
