---
theme: default
class: text-center
highlighter: shiki
lineNumbers: false
info: |
  ## Session 5: Building AI-Powered Java Apps with Spring AI
  
  Building intelligent applications with Spring AI, RAG, Tools, and MCP.
drawings:
  persist: false
transition: slide-left
title: Building AI-Powered Java Apps
mdc: true
---

# Session 5: Building AI-Powered Java Apps

**Spring AI, RAG, Tools, and MCP**

<div class="pt-12">
  <span @click="$slidev.nav.next" class="px-2 py-1 rounded cursor-pointer" hover="bg-white bg-opacity-10">
    Press Space for next page <carbon:arrow-right class="inline"/>
  </span>
</div>

<div class="abs-br m-6 flex gap-2">
  <button @click="$slidev.nav.openInEditor()" title="Open in Editor" class="text-xl slidev-icon-btn opacity-50 !border-none !hover:text-white">
    <carbon:edit />
  </button>
</div>

---
layout: center
class: text-center
---

# Welcome to Session 5!

## Building AI Apps in Java

**From Chat to Code to Application**

<div class="pt-12">
  <span class="px-2 py-1">
    Spring AI 1.1.0 + Java 21
  </span>
</div>

---
layout: default
---

# Session 5 Overview

<div class="grid grid-cols-2 gap-8">

<div>

## What We'll Cover

<v-clicks>

- **Spring AI Basics** - ChatClient, Prompts, Parsers
- **RAG (Retrieval Augmented Generation)** - Chat with your data
- **Tools & Function Calling** - Giving AI "hands"
- **Model Context Protocol (MCP)** - Connecting Cursor to Data
- **Agentic Patterns** - Building autonomous systems

</v-clicks>

</div>

<div>

## Today's Projects

<v-clicks>

- **User preference learning**
- **Performance optimization**
- **Error pattern recognition**
- **Workflow improvement**
- **Domain expertise expansion**

</v-clicks>

</div>

</div>

<div class="pt-8">

## Demo: Adaptive Agent Behavior

```typescript
// Learning agent implementation
class AdaptiveAgent {
  async learnFromFeedback(feedback: UserFeedback): Promise<void> {
    this.updateBehaviorPatterns(feedback);
    this.optimizeDecisionMaking(feedback);
    this.updateKnowledgeBase(feedback);
  }
  
  async adaptBehavior(context: Context): Promise<Behavior> {
    return this.behaviorEngine.generate(context, this.learnedPatterns);
  }
}
```

</div>

---
layout: default
---

# Student Exercise: Agent Specialization

<div class="grid grid-cols-2 gap-8">

<div>

## Your Turn: Domain-Specific Agent

<v-clicks>

- **Choose your domain:** Mobile, Backend, DevOps, etc.
- **Define specialized capabilities**
- **Create custom tool integrations**
- **Implement specialized decision-making**
- **Optimize for your domain**

</v-clicks>

</div>

<div>

## Specialization Areas

<v-clicks>

- **Mobile Development Agent**
- **Backend Services Agent**
- **DevOps Automation Agent**
- **Security Analysis Agent**
- **Performance Optimization Agent**

</v-clicks>

</div>

</div>

<div class="pt-8">

## Agent Mode Prompt

```
Agent Mode: "Create a specialized agent for your domain (e.g., 
mobile development, backend services, DevOps) with custom 
capabilities and knowledge."
```

</div>

---
layout: center
class: text-center
---

# Part 6: Real-World Agent Applications

**Production Deployment and Scaling**

<div class="pt-12">
  <span class="px-2 py-1">
    25 minutes
  </span>
</div>

---
layout: default
---

# Production Agent Deployment

<div class="grid grid-cols-2 gap-8">

<div>

## Monitoring and Management

<v-clicks>

- **Agent health monitoring**
- **Performance metrics and analytics**
- **Automated recovery mechanisms**
- **Alerting and notification systems**
- **Maintenance and updates**

</v-clicks>

</div>

<div>

## Scaling Strategies

<v-clicks>

- **Horizontal and vertical scaling**
- **Load balancing and distribution**
- **Resource management and optimization**
- **Performance monitoring and adjustment**
- **Cost optimization strategies**

</v-clicks>

</div>

</div>

<div class="pt-8">

## Demo: Agent Monitoring System

```typescript
// Agent monitoring and management
class AgentMonitor {
  async checkHealth(agent: Agent): Promise<HealthStatus> {
    return {
      status: agent.isHealthy(),
      performance: agent.getPerformanceMetrics(),
      errors: agent.getRecentErrors(),
      uptime: agent.getUptime()
    };
  }
}
```

---

# Agent Monitoring System (Scaling)

```typescript
// Agent scaling functionality
class AgentMonitor {
  async scaleAgents(workload: Workload): Promise<void> {
    const requiredAgents = this.calculateRequiredAgents(workload);
    await this.orchestrator.scaleTo(requiredAgents);
  }
}
```

</div>

---
layout: default
---

# Student Exercise: Agent Scaling

<div class="grid grid-cols-2 gap-8">

<div>

## Your Turn: Scaling Strategy Design

<v-clicks>

- **Design scaling approach**
- **Implement load balancing**
- **Manage resources efficiently**
- **Monitor performance**
- **Optimize costs**

</v-clicks>

</div>

<div>

## Scaling Considerations

<v-clicks>

- **Workload analysis**
- **Resource requirements**
- **Performance thresholds**
- **Cost optimization**
- **Failure handling**

</v-clicks>

</div>

</div>

<div class="pt-8">

## Chat Mode Prompt

```
Chat Mode: "Design a scaling strategy for AI agents that can handle 
increased workload and maintain performance."
```

</div>

---
layout: center
class: text-center
---

# BREAK

**10 minutes**

<div class="pt-12">
  <span class="px-2 py-1">
    Final stretch before exploring the future!
  </span>
</div>

---
layout: center
class: text-center
---

# Part 7: Future of AI Development

**Emerging Patterns and Trends**

<div class="pt-12">
  <span class="px-2 py-1">
    25 minutes
  </span>
</div>

---
layout: default
---

# Emerging AI Patterns

<div class="grid grid-cols-2 gap-8">

<div>

## Next-Generation Capabilities

<v-clicks>

- **Autonomous development capabilities**
- **Self-healing and self-optimizing systems**
- **Predictive development and planning**
- **Human-AI collaboration evolution**
- **Ethical considerations and governance**

</v-clicks>

</div>

<div>

## Future Development Workflows

<v-clicks>

- **AI-first development processes**
- **Collaborative human-AI teams**
- **Automated architecture decisions**
- **Predictive maintenance and optimization**
- **Continuous learning and adaptation**

</v-clicks>

</div>

</div>

<div class="pt-8">

## Demo: Autonomous Development

```typescript
// Future autonomous development system
class AutonomousDevelopmentSystem {
  async planFeature(requirements: Requirements): Promise<DevelopmentPlan> {
    return await this.planningAgent.createPlan(requirements);
  }
  
  async implementFeature(plan: DevelopmentPlan): Promise<Implementation> {
    return await this.implementationAgent.execute(plan);
  }
  
  async optimizeSystem(system: System): Promise<Optimization> {
    return await this.optimizationAgent.optimize(system);
  }
}
```

</div>

---
layout: default
---

# Student Exercise: Vision for AI Development

<div class="grid grid-cols-2 gap-8">

<div>

## Your Turn: Future Vision

<v-clicks>

- **Describe your vision for AI-assisted development**
- **How might it change software development?**
- **What challenges and opportunities do you see?**
- **How would you implement your vision?**
- **What ethical considerations are important?**

</v-clicks>

</div>

<div>

## Vision Components

<v-clicks>

- **Future development workflows**
- **Human-AI collaboration patterns**
- **Technology evolution and adoption**
- **Challenges and opportunities**
- **Implementation strategies**

</v-clicks>

</div>

</div>

<div class="pt-8">

## Chat Mode Prompt

```
Chat Mode: "Describe your vision for the future of AI-assisted development 
and how it might change the way we build software."
```

</div>

---
layout: center
class: text-center
---

# Part 8: Legacy System Agent Integration

**Modernizing Legacy Systems with AI**

<div class="pt-12">
  <span class="px-2 py-1">
    15 minutes
  </span>
</div>

---
layout: default
---

# Legacy System Analysis

<div class="grid grid-cols-2 gap-8">

<div>

## Legacy Challenges

<v-clicks>

- **Outdated architecture and patterns**
- **Technical debt and maintenance issues**
- **Integration complexity**
- **Performance bottlenecks**
- **Security vulnerabilities**

</v-clicks>

</div>

<div>

## Agent Integration Strategies

<v-clicks>

- **Gradual modernization approach**
- **Agent-assisted refactoring**
- **Incremental improvement**
- **Risk assessment and mitigation**
- **Implementation roadmap**

</v-clicks>

</div>

</div>

<div class="pt-8">

## Demo: Legacy Modernization Agent

```typescript
// Legacy modernization agent
class LegacyModernizationAgent {
  async analyzeLegacySystem(system: LegacySystem): Promise<Analysis> {
    return {
      technicalDebt: this.assessTechnicalDebt(system),
      modernizationOpportunities: this.identifyOpportunities(system),
      riskAssessment: this.assessRisks(system),
      implementationPlan: this.createPlan(system)
    };
  }
  
  async modernizeIncrementally(system: LegacySystem): Promise<Modernization> {
    return await this.executeModernizationPlan(system);
  }
}
```

</div>

---
layout: default
---

# Student Guided Exploration

<div class="grid grid-cols-2 gap-8">

<div>

## Exploration Questions

<v-clicks>

- **What are the main challenges in integrating AI agents with legacy systems?**
- **How would you prioritize agent integration efforts?**
- **What risks should be considered when modernizing legacy systems with AI?**

</v-clicks>

</div>

<div>

## Extended Thinking Prompts

<v-clicks>

- **"Analyze this legacy enterprise application and design an agent integration strategy"**
- **"Identify modernization opportunities and create an implementation roadmap"**
- **"Assess risks and create mitigation strategies for legacy system modernization"**

</v-clicks>

</div>

</div>

<div class="pt-8">

## Your Turn: Legacy Analysis

Use Extended Thinking to explore:
1. **Legacy system challenges and opportunities**
2. **Agent integration prioritization**
3. **Risk assessment and mitigation strategies**

</div>

---
layout: center
class: text-center
---

# Wrap-Up & Next Steps

**Course Completion and Future Learning**

<div class="pt-12">
  <span class="px-2 py-1">
    10 minutes
  </span>
</div>

---
layout: default
---

# Key Takeaways

<div class="grid grid-cols-2 gap-8">

<div>

## Agent Development Decision Tree

<v-clicks>

- **Need specialized expertise?** → Create domain-specific agents
- **Need multi-step workflows?** → Implement agent orchestration
- **Need enterprise integration?** → Use MCP for tool connectivity
- **Need learning capabilities?** → Implement adaptive agents
- **Need production deployment?** → Design monitoring and management
- **Need future planning?** → Explore emerging AI patterns

</v-clicks>

</div>

<div>

## What We Accomplished

<v-clicks>

- ✅ **Custom AI agent development**
- ✅ **Multi-agent collaboration patterns**
- ✅ **Enterprise tool integration with MCP**
- ✅ **Advanced agent patterns and learning**
- ✅ **Production deployment strategies**
- ✅ **Future AI development exploration**

</v-clicks>

</div>

</div>

---
layout: default
---

# Complete Cursor Training Journey

<div class="grid grid-cols-2 gap-8">

<div>

## Our Learning Path

<v-clicks>

- **Session 1:** Chat, Agent, Composer modes
- **Session 2:** Mobile development with AI
- **Session 3:** Agentic coding principles
- **Session 4:** AI-assisted testing and quality
- **Session 5:** Advanced agents and MCP

</v-clicks>

</div>

<div>

## Next Steps

<v-clicks>

- **Apply learned concepts to your projects**
- **Experiment with custom agents and MCP**
- **Explore advanced AI development patterns**
- **Continue learning and adapting to AI evolution**
- **Share knowledge with your teams**

</v-clicks>

</div>

</div>

<div class="pt-8">

## Thank You!

**You're now equipped with advanced AI development skills!**

</div>

---
layout: center
class: text-center
---

# Questions & Discussion

<div class="pt-12">
  <span class="px-2 py-1">
    Let's explore advanced agent questions together!
  </span>
</div>

<div class="abs-br m-6 flex gap-2">
  <span class="text-sm opacity-50">
    Session 5 Complete
  </span>
</div>

---
layout: center
class: text-center
---

# Session 5 Complete!

## Exploring Agents and MCP

**Advanced AI Agent Development and Model Context Protocol Integration**

<div class="pt-12">
  <span class="px-2 py-1">
    Ready for the labs? Let's build some agents!
  </span>
</div>

<div class="abs-br m-6 flex gap-2">
  <span class="text-sm opacity-50">
    Advanced AI Development
  </span>
</div>
